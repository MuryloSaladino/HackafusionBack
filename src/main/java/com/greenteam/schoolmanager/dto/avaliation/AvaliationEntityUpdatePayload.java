package com.greenteam.schoolmanager.dto.avaliation;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

@Getter @Data
public class AvaliationEntityUpdatePayload {

    @Pattern(regexp = "\\b(QUALIFIED|UNQUALIFIED|LEARNING)\\b")
    private String status;
}
