package com.greenteam.schoolmanager.repositories;

import com.greenteam.schoolmanager.entities.StudentGangDisciplineEntity;
import com.greenteam.schoolmanager.entities.StudentGangEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGangDisciplineRepository extends CrudRepository<StudentGangDisciplineEntity, Long> {
    List<StudentGangDisciplineEntity> findByGang(StudentGangEntity studentGang);
}
