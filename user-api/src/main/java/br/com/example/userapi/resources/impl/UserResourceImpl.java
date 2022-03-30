package br.com.example.userapi.resources.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.userapi.domain.User;
import br.com.example.userapi.resources.UserResource;
import br.com.example.userapi.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserResourceImpl implements UserResource {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<User> findById(Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

}
