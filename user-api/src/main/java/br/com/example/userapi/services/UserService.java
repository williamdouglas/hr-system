package br.com.example.userapi.services;

import java.util.List;

import br.com.example.userapi.domain.User;

public interface UserService {

    public User findById(Long id);

    public List<User> findAll();

}
