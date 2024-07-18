package com.greenteam.schoolmanager.dto.student;

import com.greenteam.schoolmanager.dto.avaliation.CompetenceAvaliationEntityResponse;
import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityResponse;
import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.entities.CompetenceAvaliationEntity;
import com.greenteam.schoolmanager.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class StudentGradesResponse {

    public UserEntityResponse user;
    public List<AvaliationRecord> avaliations = new ArrayList<>();


    public StudentGradesResponse(UserEntity user, List<List<CompetenceAvaliationEntity>> allAvaliations) {
        this.user = new UserEntityResponse(user);

        for(var avaliation : allAvaliations) {
            if(avaliation.isEmpty()) continue;

            avaliations.add(new AvaliationRecord(
                    avaliation.getFirst().getAvaliationEntity().getId(),
                    new DisciplineEntityResponse(avaliation.getFirst().getAvaliationEntity().getDisciplineEntity()),
                    avaliation.stream().map(CompetenceAvaliationEntityResponse::new).toList()
            ));
        }
    }


    private record AvaliationRecord(
            Long id,
            DisciplineEntityResponse discipline,
            List<CompetenceAvaliationEntityResponse> competences
    ) {}
}
