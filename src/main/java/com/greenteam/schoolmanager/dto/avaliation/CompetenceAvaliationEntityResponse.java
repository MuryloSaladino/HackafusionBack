package com.greenteam.schoolmanager.dto.avaliation;

import com.greenteam.schoolmanager.dto.competence.CompetenceEntityResponse;
import com.greenteam.schoolmanager.dto.discipline.DisciplineEntityResponse;
import com.greenteam.schoolmanager.dto.user.UserEntityResponse;
import com.greenteam.schoolmanager.entities.CompetenceAvaliationEntity;
import com.greenteam.schoolmanager.entities.CompetenceEntity;
import com.greenteam.schoolmanager.entities.DisciplineEntity;
import com.greenteam.schoolmanager.entities.UserEntity;
import com.greenteam.schoolmanager.enums.CompetenceLevel;

public class CompetenceAvaliationEntityResponse {

    public Long id;
    public CompetenceLevel status;
    public CompetenceEntityResponse competence;

    public CompetenceAvaliationEntityResponse(CompetenceAvaliationEntity competenceAvaliationEntity) {
        this.id = competenceAvaliationEntity.getId();
        this.status = competenceAvaliationEntity.getStatus();
        this.competence = new CompetenceEntityResponse(competenceAvaliationEntity.getCompetence());
    }
}
