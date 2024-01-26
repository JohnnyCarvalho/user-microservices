package com.ecommerce.registeruserapi.repositories;

import com.ecommerce.registeruserapi.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);

    User findUserByUserName(String userName);
}
