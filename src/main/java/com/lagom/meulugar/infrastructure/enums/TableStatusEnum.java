package com.lagom.meulugar.infrastructure.enums;

public enum TableStatusEnum {

    AVAIABLE("Disponível"),
    RESERVED("Reservada"),
    INACTIVE("Inativa"),
    UNAVAIABLE("Indisponível");

    private String description;

    TableStatusEnum(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

}
