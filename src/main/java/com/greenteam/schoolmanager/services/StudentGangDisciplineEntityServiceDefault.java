package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.entities.StudentGangDisciplineEntity;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.StudentGangDisciplineEntityService;
import com.greenteam.schoolmanager.repositories.DisciplineRepository;
import com.greenteam.schoolmanager.repositories.StudentGangDisciplineRepository;
import com.greenteam.schoolmanager.repositories.StudentGangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentGangDisciplineEntityServiceDefault implements StudentGangDisciplineEntityService {

    @Autowired
    StudentGangDisciplineRepository studentGangDisciplineRepository;

    @Autowired
    StudentGangRepository studentGangRepository;

    @Autowired
    DisciplineRepository disciplineRepository;


    @Override
    public StudentGangDisciplineEntity create(Long studentGangId, Long disciplineId) {

        StudentGangDisciplineEntity newStudentGangDiscipline = new StudentGangDisciplineEntity();

        var gangQuery = studentGangRepository.findById(studentGangId);
        if(gangQuery.isEmpty()) throw new NotFoundException();

        var disciplineQuery = disciplineRepository.findById(disciplineId);
        if(disciplineQuery.isEmpty()) throw new NotFoundException();

        var studentGang = gangQuery.get();
        var discipline = disciplineQuery.get();

        newStudentGangDiscipline.setGang(studentGang);
        newStudentGangDiscipline.setDiscipline(discipline);

        return studentGangDisciplineRepository.save(newStudentGangDiscipline);
    }
}
