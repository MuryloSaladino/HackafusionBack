package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.user.PreRegisterPayload;
import com.greenteam.schoolmanager.dto.user.UserEntityCreationPayload;
import com.greenteam.schoolmanager.entities.PreRegisterEntity;
import com.greenteam.schoolmanager.entities.UserEntity;
import com.greenteam.schoolmanager.enums.UserRole;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.JwtTokenManager;
import com.greenteam.schoolmanager.interfaces.PreRegisterService;
import com.greenteam.schoolmanager.repositories.PreRegisterRepository;
import com.greenteam.schoolmanager.repositories.StudentGangRepository;
import com.greenteam.schoolmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PreRegisterServiceDefault implements PreRegisterService {

    @Autowired
    private PreRegisterRepository preRegisterRepository;

    @Autowired
    private StudentGangRepository studentGangRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenManager jwtTokenManager;


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
    public String getByEmail(String email) {

        var query = preRegisterRepository.findByEmail(email);
        if(query.isEmpty()) throw new NotFoundException("Pre Register Not Found");

        var preRegisterEntity = query.get();

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("role", UserRole.roleToInteger(preRegisterEntity.getRole()));

        if(preRegisterEntity.getRole().equals(UserRole.STUDENT)) {
            var gangQuery = studentGangRepository.findById(preRegisterEntity.getStudentGang().getId());
            if(gangQuery.isEmpty()) throw new NotFoundException("Student Gang Not Found");

            claims.put("gangId", gangQuery.get().getId());
        }

        return jwtTokenManager.buildToken(claims, "", null);
    }

    @Override
    public UserEntity createFromPreRegister(UserEntityCreationPayload payload) {
        return null;
    }
}
