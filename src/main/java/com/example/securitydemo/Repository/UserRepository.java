package com.example.securitydemo.Repository;

import com.example.securitydemo.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findOneByusername(String username);
}
