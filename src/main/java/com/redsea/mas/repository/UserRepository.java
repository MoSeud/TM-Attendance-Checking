package com.redsea.mas.repository;

import com.redsea.mas.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {


    User findByEmail(String email);
}
