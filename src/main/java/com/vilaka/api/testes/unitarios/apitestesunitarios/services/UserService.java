package com.vilaka.api.testes.unitarios.apitestesunitarios.services;

import com.vilaka.api.testes.unitarios.apitestesunitarios.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();
}
