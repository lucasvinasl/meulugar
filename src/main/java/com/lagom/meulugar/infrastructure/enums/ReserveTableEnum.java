package com.lagom.meulugar.infrastructure.enums;

public enum ReserveTableEnum {

    CONFIRMED("Confirmada"),
    CANCELED("Cancelada"),
    PENDING("Pendente");

    private String description;

    ReserveTableEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
