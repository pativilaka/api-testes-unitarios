package com.vilaka.api.testes.unitarios.apitestesunitarios.services.impl;

import com.vilaka.api.testes.unitarios.apitestesunitarios.domain.User;
import com.vilaka.api.testes.unitarios.apitestesunitarios.exceptions.ObjectNotFoundException;
import com.vilaka.api.testes.unitarios.apitestesunitarios.repositories.UserRepository;
import com.vilaka.api.testes.unitarios.apitestesunitarios.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado."));
    }

    public List<User> findAll(){
        return repository.findAll();
    }
}
