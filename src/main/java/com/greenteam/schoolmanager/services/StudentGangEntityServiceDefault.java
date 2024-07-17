package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.gang.StudentGangEntityCreationPayload;
import com.greenteam.schoolmanager.dto.gang.StudentGangEntityUpdatePayload;
import com.greenteam.schoolmanager.entities.StudentGangEntity;
import com.greenteam.schoolmanager.enums.DisciplineType;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.StudentGangEntityService;
import com.greenteam.schoolmanager.repositories.StudentGangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentGangEntityServiceDefault implements StudentGangEntityService {

    @Autowired
    StudentGangRepository studentGangRepository;

    @Override
    public StudentGangEntity create(StudentGangEntityCreationPayload payload) {

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
    public List<StudentGangEntity> getByMainDiscipline(String disciplineName) {
        return studentGangRepository.findByMainDisciplineType(DisciplineType.valueOf(disciplineName));
    }


    @Override
    public StudentGangEntity update(Long id, StudentGangEntityUpdatePayload payload) {

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
