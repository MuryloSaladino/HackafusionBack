package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.register.PreRegisterPayload;
import com.greenteam.schoolmanager.dto.user.UserEntityCreationPayload;
import com.greenteam.schoolmanager.entities.PreRegisterEntity;
import com.greenteam.schoolmanager.entities.UserEntity;
import com.greenteam.schoolmanager.enums.UserRole;
import com.greenteam.schoolmanager.exceptions.BadRequestException;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.PreRegisterService;
import com.greenteam.schoolmanager.repositories.PreRegisterRepository;
import com.greenteam.schoolmanager.repositories.StudentGangRepository;
import com.greenteam.schoolmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PreRegisterServiceDefault implements PreRegisterService {

    @Autowired
    private PreRegisterRepository preRegisterRepository;

    @Autowired
    private StudentGangRepository studentGangRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void createPreRegister(PreRegisterPayload payload) {

        var preRegisterEntity = payload.toEntity();

        if(payload.getRole().equals(2)) {
            var query = studentGangRepository.findById(payload.getStudentGangId());
            if(query.isEmpty()) throw new NotFoundException("Student Gang Not Found");

            preRegisterEntity.setStudentGang(query.get());
        }

        preRegisterRepository.save(preRegisterEntity);
    }

    @Override
    public PreRegisterEntity getByEmail(String email) {

        var query = preRegisterRepository.findByEmail(email);
        if(query.isEmpty()) throw new NotFoundException("Pre Register Not Found");

        return query.get();
    }

    @Override
    public UserEntity createFromPreRegister(UserEntityCreationPayload payload) {

        var preRegister = getByEmail(payload.getEmail());
        var newUser = payload.toEntity();

        if(!preRegister.getEmail().equals(payload.getEmail()))
            throw new BadRequestException("Invalid Email");
        if(!preRegister.getRole().equals(UserRole.integerToRole(payload.getRole())))
            throw new BadRequestException("Invalid Role");

        if(preRegister.getRole().equals(UserRole.STUDENT)) {
            newUser.setStudentGang(preRegister.getStudentGang());
        }

        newUser.setPassword(bCryptPasswordEncoder.encode(payload.getPassword()));

        preRegisterRepository.delete(preRegister);
        return userRepository.save(newUser);
    }
}
