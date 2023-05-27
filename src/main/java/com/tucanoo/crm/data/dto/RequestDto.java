package com.tucanoo.crm.data.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto {

    @NotBlank
    String name;

    String description;

    String fullName;

    String type;

    String emailAddress;

    String phoneNumber;
}
