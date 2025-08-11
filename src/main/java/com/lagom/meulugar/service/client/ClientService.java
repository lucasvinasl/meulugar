package com.lagom.meulugar.service.client;

import com.lagom.meulugar.dto.CreateClientRequestDTO;
import com.lagom.meulugar.model.client.Client;
import com.lagom.meulugar.repository.client.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;



    public Client findByEmail(String email){
        return clientRepository.findByEmail(email.toLowerCase().trim())
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado."));
    }

    @Transactional
    public Client createClient(CreateClientRequestDTO form){
        if(clientRepository.findByEmail(form.getEmail().toLowerCase().trim()).isPresent()){
            throw new IllegalArgumentException("Já existe um usuário com o email cadastrado!");
        }

        if(clientRepository.findByIdentifier(form.getIdentifier()).isPresent()){
            throw new IllegalArgumentException("Já existe um usuário com o CPF cadastrado!");
        }

        if(clientRepository.findByPhone(form.getIdentifier().replaceAll("\\D", "")).isPresent()){
            throw new IllegalArgumentException("Já existe um usuário com o CPF cadastrado!");
        }

        Client client = new Client();
        client.setId(null);
        client.setName(form.getFullName());
        client.setEmail(form.getEmail());
        client.setPhone(form.getPhone().replaceAll("\\D", ""));
        client.setIdentifier(form.getIdentifier());
        client = clientRepository.saveAndFlush(client);
        return client;
    }

}
