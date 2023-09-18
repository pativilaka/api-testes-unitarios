package com.vilaka.api.testes.unitarios.apitestesunitarios.resources;

import com.vilaka.api.testes.unitarios.apitestesunitarios.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResources {

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){

        return ResponseEntity.ok().body(new User(2, "Rafa", "rafa@gmail.com","524"));
    }
}
