package com.yashpawar5.User.Registration.Repositories;

import com.yashpawar5.User.Registration.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String userName);
}
