package com.lagom.meulugar.repository.client;

import com.lagom.meulugar.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("""
    select c from Client c where lower(c.email) = :email
    """)
    Optional<Client> findByEmail(String email);

    @Query("""
    select c from Client c where c.identifier = :identifier
    """)
    Optional<Client> findByIdentifier(String identifier);

    @Query("""
    select c from Client c where c.phone = :phone
    """)
    Optional<Client> findByPhone(String phone);

}
