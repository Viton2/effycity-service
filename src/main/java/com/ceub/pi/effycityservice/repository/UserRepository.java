package com.ceub.pi.effycityservice.repository;

import com.ceub.pi.effycityservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameOrEmail(String username, String email);
}
