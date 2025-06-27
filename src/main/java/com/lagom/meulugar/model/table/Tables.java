package com.lagom.meulugar.model.table;

import com.lagom.meulugar.infrastructure.enums.TableStatusEnum;
import com.lagom.meulugar.model.reserve.Reserve;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String tableIdentifier;

    @NotNull
    @Column(nullable = false)
    private Integer capacity;

    @ManyToMany(mappedBy = "tables")
    private List<Reserve> reserves = new ArrayList<>();

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TableStatusEnum status;
}
