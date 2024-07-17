package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.user.UserEntityCreationPayload;
import com.greenteam.schoolmanager.dto.user.UserEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.UserEntity;
import com.greenteam.schoolmanager.enums.UserRole;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.UserEntityService;
import com.greenteam.schoolmanager.repositories.PreRegisterRepository;
import com.greenteam.schoolmanager.repositories.StudentGangRepository;
import com.greenteam.schoolmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityServiceDefault implements UserEntityService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    StudentGangRepository studentGangRepository;

    @Autowired
    PreRegisterRepository preRegisterRepository;


    @Override
    public UserEntity create(UserEntityCreationPayload payload) {

        UserEntity newUser = payload.toEntity();
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

        if(newUser.getRole().equals(UserRole.STUDENT)) {
            var query = studentGangRepository.findById(payload.getStudentGangId());
            if(query.isEmpty()) throw new NotFoundException();

            newUser.setStudentGang(query.get());
        }

        return userRepository.save(newUser);
    }

    @Override
    public UserEntity getById(Long id) {

        var query = userRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        return query.get();
    }

    @Override
    public UserEntity getByUsernameOrEmail(String usernameOrEmail) {

        UserEntity user = null;

        var emailQuery = userRepository.findByEmail(usernameOrEmail);
        var usernameQuery = userRepository.findByUsername(usernameOrEmail);

        if(emailQuery.isPresent()) user = emailQuery.get();
        if(usernameQuery.isPresent()) user = usernameQuery.get();

        if(user == null) throw new NotFoundException("User not found");

        return user;
    }

    @Override
    public List<UserEntity> getAll() {
        return (List<UserEntity>) userRepository.findAll();
    }

    @Override
    public UserEntity update(Long id, UserEntityUpdatePayload payload) {

        var query = userRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        var user = query.get();
        if(payload.getEmail() != null) user.setEmail(payload.getEmail());
        if(payload.getPassword() != null) user.setPassword(bCryptPasswordEncoder.encode(payload.getPassword()));
        if(payload.getFullname() != null) user.setFullname(payload.getFullname());
        if(payload.getUsername() != null) user.setUsername(payload.getUsername());

        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {

        var query = userRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        userRepository.delete(query.get());
    }
}
