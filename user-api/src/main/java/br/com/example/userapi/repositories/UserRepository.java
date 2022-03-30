package br.com.example.userapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.example.userapi.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
