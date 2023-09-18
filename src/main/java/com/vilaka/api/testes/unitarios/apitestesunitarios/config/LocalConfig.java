package com.vilaka.api.testes.unitarios.apitestesunitarios.config;

import com.vilaka.api.testes.unitarios.apitestesunitarios.domain.User;
import com.vilaka.api.testes.unitarios.apitestesunitarios.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean //Subir sempre que o perfil estiver ativo
    public void startDB() {
        User u1 = new User(null, "Pati Nunes", "pati@gmail.com", "0123");
        User u2 = new User(null, "Rafa Nunes", "rafa@gmail.com", "7894");

        repository.saveAll(List.of(u1,u2));
    }
}
