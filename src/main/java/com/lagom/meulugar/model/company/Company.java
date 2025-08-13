package com.lagom.meulugar.model.company;

import com.lagom.meulugar.model.user.UserAccount;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customName;

    private String identifier;

    private String officialName;

    private boolean active = true;

    private ZonedDateTime createdAt = ZonedDateTime.now();

    @OneToMany(mappedBy = "company")
    private Set<UserAccount> userAccounts = new HashSet<>();
}
