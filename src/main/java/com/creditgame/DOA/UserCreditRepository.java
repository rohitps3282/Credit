package com.creditgame.DOA;

import com.creditgame.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCreditRepository extends JpaRepository<User,Integer> {
    User findByName(String name);
}
