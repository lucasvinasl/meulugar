package com.lagom.meulugar.model.reserve;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReserveTable implements Serializable {
    private Long reserveId;
    private Long tableId;
    private ZonedDateTime reservedAt;
}
