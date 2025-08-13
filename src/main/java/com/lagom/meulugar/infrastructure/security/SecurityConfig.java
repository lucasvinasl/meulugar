package com.lagom.meulugar.infrastructure.security;

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class SecurityConfig {
    // Configuração do Spring Security Padrões

    // Filter Chain
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http){
//        try{
//            /*
//            CSRF -> é uma proteção a um tipo de ataque, onde o usuário logado em um site, entra em um outro site malicioso
//            esse site malicioso consegue mandar requisições ao site original usando os cookies ou a sessão do usuário autenticado.
//            */
//
//            /*
//                Por padrão o Spring Security cirar um token CSRF para cada sessão, ou seja, para cada POST,PUT,etc.
//                Esse token deve ser enviado junto com cada requisição de alteração.
//                Se o token não bater com o esperado, o Spring bloqueia a requisição.
//             */
//
//            /*
//            Com o padrão REST stateless (não há sessão/cookies automáticos), O navegador não envia o token JWT automaticamente.
//            É usado Authorization Bearer Token no header da requisição, não precisamos dessa proteção.
//            */
////            http.csrf(csrf -> csrf.disable())
////                    .authorizeHttpRequests(auth -> )
//            return http.build();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }

}
