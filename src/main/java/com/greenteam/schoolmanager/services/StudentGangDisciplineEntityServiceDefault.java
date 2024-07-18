package com.greenteam.schoolmanager.services;

import com.greenteam.schoolmanager.dto.studentGangDiscipline.StudentGangDisciplineCreationPayload;
import com.greenteam.schoolmanager.entities.DisciplineEntity;
import com.greenteam.schoolmanager.entities.StudentGangDisciplineEntity;
import com.greenteam.schoolmanager.entities.StudentGangEntity;
import com.greenteam.schoolmanager.exceptions.NotFoundException;
import com.greenteam.schoolmanager.interfaces.StudentGangDisciplineEntityService;
import com.greenteam.schoolmanager.repositories.DisciplineRepository;
import com.greenteam.schoolmanager.repositories.StudentGangDisciplineRepository;
import com.greenteam.schoolmanager.repositories.StudentGangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentGangDisciplineEntityServiceDefault implements StudentGangDisciplineEntityService {

    @Autowired
    StudentGangDisciplineRepository studentGangDisciplineRepository;

    @Autowired
    StudentGangRepository studentGangRepository;

    @Autowired
    DisciplineRepository disciplineRepository;


    @Override
    public StudentGangDisciplineEntity create(StudentGangDisciplineCreationPayload payload) {

        StudentGangDisciplineEntity newStudentGangDiscipline = payload.toEntity();

        var gangQuery = studentGangRepository.findById(payload.getGangId());
        if(gangQuery.isEmpty()) throw new NotFoundException();

        var disciplineQuery = disciplineRepository.findById(payload.getDisciplineId());
        if(disciplineQuery.isEmpty()) throw new NotFoundException();

        var studentGang = gangQuery.get();
        var discipline = disciplineQuery.get();

        newStudentGangDiscipline.setGang(studentGang);
        newStudentGangDiscipline.setDiscipline(discipline);

        return studentGangDisciplineRepository.save(newStudentGangDiscipline);
    }

    @Override
    public List<DisciplineEntity> findByGangNotContaining(Long gang) {
        var queryGang = studentGangRepository.findById(gang);
        if(queryGang.isEmpty()) throw new NotFoundException();

        var queryDisciplines = disciplineRepository.findAll();

        var queryContained = studentGangDisciplineRepository
                .findByGang(queryGang.get())
                .stream()
                .map(x -> x.getDiscipline())
                .toList();


        var notContained = new ArrayList<DisciplineEntity>();

        queryDisciplines.forEach(x -> {
            if (!queryContained.contains(x)) {
                notContained.add((x));
            }
        });

        return notContained;
    }

    @Override
    public void delete(Long id) {
        var query = studentGangDisciplineRepository.findById(id);
        if (query.isEmpty()) throw new NotFoundException();

        studentGangDisciplineRepository.delete(query.get());
    }

}
