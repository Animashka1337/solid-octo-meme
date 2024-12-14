package com.example.endtermgmail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    public UserEntity findByName(String name);
}
