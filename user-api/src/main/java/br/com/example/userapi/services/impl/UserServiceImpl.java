package br.com.example.userapi.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.userapi.domain.User;
import br.com.example.userapi.repositories.UserRepository;
import br.com.example.userapi.services.UserService;
import br.com.example.userapi.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
