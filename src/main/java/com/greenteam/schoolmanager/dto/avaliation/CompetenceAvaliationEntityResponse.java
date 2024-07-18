package com.greenteam.schoolmanager.dto.avaliation;

import com.greenteam.schoolmanager.entities.CompetenceAvaliationEntity;
import com.greenteam.schoolmanager.entities.CompetenceEntity;
import com.greenteam.schoolmanager.entities.DisciplineEntity;
import com.greenteam.schoolmanager.entities.UserEntity;
import com.greenteam.schoolmanager.enums.CompetenceLevel;

public class CompetenceAvaliationEntityResponse {

    public Long id;
    public CompetenceEntity competence;
    public UserEntity user;
    public CompetenceLevel status;
    public DisciplineEntity discipline;

    public CompetenceAvaliationEntityResponse(CompetenceAvaliationEntity competenceAvaliationEntity) {
        this.id = competenceAvaliationEntity.getId();
        this.competence = competenceAvaliationEntity.getCompetence();
        this.user = competenceAvaliationEntity.getAvaliationEntity().getUser();
        this.status = competenceAvaliationEntity.getStatus();
        this.discipline = competenceAvaliationEntity.getAvaliationEntity().getDisciplineEntity();
    }
}
