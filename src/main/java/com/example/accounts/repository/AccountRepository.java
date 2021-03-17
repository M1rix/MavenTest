package com.example.accounts.repository;

import com.example.accounts.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<User,Long> {
}
