package com.lagom.meulugar.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginClientRequestDTO {
    @Email(message = "O email deve ter um formato válido")
    private String email;

    @Length(min = 8, max = 100)
    private String password;
}
