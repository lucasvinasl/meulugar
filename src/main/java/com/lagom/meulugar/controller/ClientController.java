package com.lagom.meulugar.controller;

import com.lagom.meulugar.dto.ClientLoginRequestDTO;
import com.lagom.meulugar.dto.CreateClientRequestDTO;
import com.lagom.meulugar.dto.CreateClientResponseDTO;
import com.lagom.meulugar.model.client.Client;
import com.lagom.meulugar.service.client.ClientService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<CreateClientResponseDTO> create(@Valid @RequestBody CreateClientRequestDTO createForm){
        Client client = clientService.createClient(createForm);
        var response = CreateClientResponseDTO.builder()
                .id(client.getId())
                .email(client.getEmail())
                .password(client.getPassword())
                .fullName(client.getName())
                .identifier(client.getIdentifier()).build();
        return ResponseEntity.ok().body(response);
    }

//    @PostMapping("/auth")
//    public ResponseEntity<ClientLoginRequestDTO> auth(@RequestBody @Validated ClientLoginRequestDTO login, HttpServletRequest){
//        return ResponseEntity.ok().body();
//    }

}
