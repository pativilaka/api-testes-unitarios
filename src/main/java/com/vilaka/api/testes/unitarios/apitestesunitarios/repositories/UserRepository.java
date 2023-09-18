package com.vilaka.api.testes.unitarios.apitestesunitarios.repositories;

import com.vilaka.api.testes.unitarios.apitestesunitarios.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
