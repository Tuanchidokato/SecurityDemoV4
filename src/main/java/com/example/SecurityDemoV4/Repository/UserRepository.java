package com.example.SecurityDemoV4.Repository;

import com.example.SecurityDemoV4.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findByUsername(String username);
    public Optional<User> findById(Long id);

}
