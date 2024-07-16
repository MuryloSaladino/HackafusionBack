package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.gang.StudentGangCreationPayload;
import com.greenteam.schoolmanager.dto.gang.StudentGangUpdatePayload;
import com.greenteam.schoolmanager.entities.StudentGangEntity;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.StudentGangService;
import com.greenteam.schoolmanager.repositories.StudentGangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGangServiceDefault implements StudentGangService {

    @Autowired
    StudentGangRepository studentGangRepository;

    @Override
    public StudentGangEntity create(StudentGangCreationPayload payload) {

        StudentGangEntity newStudentGang = payload.toEntity();

        return studentGangRepository.save(newStudentGang);
    }

    @Override
    public StudentGangEntity getById(Long id) {

        var query = studentGangRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        return query.get();
    }

    @Override
    public List<StudentGangEntity> getAll() { return (List<StudentGangEntity>) studentGangRepository.findAll(); }

    @Override
    public StudentGangEntity update(Long id, StudentGangUpdatePayload payload) {

        var query = studentGangRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        var gang = query.get();
        if(payload.getName() != null) gang.setName(payload.getName());
        if(payload.getMainDisciplineType() != null) gang.setMainDisciplineType(payload.getMainDisciplineType());

        return studentGangRepository.save(gang);
    }

    @Override
    public void delete(Long id) {

        var query = studentGangRepository.findById(id);
        if(query.isEmpty()) throw new NotFoundException();

        studentGangRepository.delete(query.get());
    }
}
