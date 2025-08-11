package com.lagom.meulugar.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateClientResponseDTO {

    private Long id;

    private String email;

    private String password;

    private String fullName;

    private String identifier;

    private String phone;

}
