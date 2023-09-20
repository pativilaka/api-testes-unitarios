package com.vilaka.api.testes.unitarios.apitestesunitarios.services.impl;

import com.vilaka.api.testes.unitarios.apitestesunitarios.domain.User;
import com.vilaka.api.testes.unitarios.apitestesunitarios.domain.dto.UserDTO;
import com.vilaka.api.testes.unitarios.apitestesunitarios.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID      = 1;
    public static final String NAME     = "Pati Nunes";
    public static final String EMAIL    = "p.vilaka@gmai.com";
    public static final String PASSWORD = "123";

    @InjectMocks //Criamos a 1º instância real e o resto ele faz pra gente
    private UserServiceImpl service;

    @Mock //Não é real
    private UserRepository repository;
    //é importante ter uma instância mockada, pois como ele faz uma chamada, ele poderá dar uma
    //exceção de ponteiro nulo

    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDto;
    private Optional<User> optionalUser;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDto = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(optionalUser); //Import static method Mokito
        User response = service.findById(ID);
        //Assegura que meu objeto não é nulo -- método static foi importado para melhorar código
        assertNotNull(response);
        //Assegura que o que eu espero seja igual ao que realmente veio
        assertEquals(User.class, response.getClass());
        //Assegura que o ID é exatamente o valor que veio
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}