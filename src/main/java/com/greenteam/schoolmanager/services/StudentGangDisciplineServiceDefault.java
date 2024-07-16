package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.gang.StudentGangCreationPayload;
import com.greenteam.schoolmanager.dto.gang.StudentGangUpdatePayload;
import com.greenteam.schoolmanager.entities.StudentGangDisciplineEntity;
import com.greenteam.schoolmanager.interfaces.StudentGangDisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGangDisciplineServiceDefault implements StudentGangDisciplineService {

    @Autowired


    @Override
    public StudentGangDisciplineEntity create(StudentGangCreationPayload payload) {
        return null;
    }

    @Override
    public StudentGangDisciplineEntity getById(Long id) {
        return null;
    }

    @Override
    public List<StudentGangDisciplineEntity> getAll() {
        return List.of();
    }

    @Override
    public StudentGangDisciplineEntity update(StudentGangUpdatePayload payload) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
