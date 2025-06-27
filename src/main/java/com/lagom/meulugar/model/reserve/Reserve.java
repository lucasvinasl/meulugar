package com.lagom.meulugar.model.reserve;

import com.lagom.meulugar.model.table.Tables;
import com.lagom.meulugar.model.user.UserAccount;
import com.lagom.meulugar.model.client.Client;
import com.lagom.meulugar.infrastructure.enums.ReserveTableEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserAccount userAccount;

    @NotNull
    @ManyToMany
    @JoinTable(
            name = "reserve_table",
            joinColumns = @JoinColumn(name = "reserve_id"),
            inverseJoinColumns = @JoinColumn(name = "table_id")
    )
    private List<Tables> tables = new ArrayList<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @NotNull
    @Column(nullable = false)
    private ZonedDateTime reservedAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReserveTableEnum status;
}
