package com.example.bankingportal.repository;

import com.example.bankingportal.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * UserRepository
 *
 * @author fuhao
 * @date 2022/5/24
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
