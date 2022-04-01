package br.com.example.userapi.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.example.userapi.domain.User;
import br.com.example.userapi.repositories.UserRepository;
import br.com.example.userapi.services.UserService;
import br.com.example.userapi.services.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Environment env;

    @Override
    public User findById(Long id) {
        logger.info("USER_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port.");

        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
