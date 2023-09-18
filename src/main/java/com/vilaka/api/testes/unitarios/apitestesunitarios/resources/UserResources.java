package com.vilaka.api.testes.unitarios.apitestesunitarios.resources;

import com.vilaka.api.testes.unitarios.apitestesunitarios.domain.dto.UserDTO;
import com.vilaka.api.testes.unitarios.apitestesunitarios.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
public class UserResources {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){

        return ResponseEntity.ok().body(mapper.map(service.findById(id), UserDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        //List<User> list = service.findAll();
        //List<UserDTO> listDTO = service.findAll().stream().map(x-> mapper.map(x, UserDTO.class)).collect(Collectors.toList());
        return ResponseEntity.ok().body(service.findAll().stream().map(
                x-> mapper.map(x, UserDTO.class)).collect(Collectors.toList()));
    }
}
