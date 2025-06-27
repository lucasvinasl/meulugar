package com.lagom.meulugar.repository.client;

import com.lagom.meulugar.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
