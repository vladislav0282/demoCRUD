package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long> {
    @Query(value = "SELECT * FROM userdemo WHERE email = :email", nativeQuery = true)
    //Optional <User> findeByEmail (@Param(value="email") String email); // @Param(value="email") если поле в БД отличается, а если совпадают то можно не указывать
    Optional <User> findeByEmail (String email);
}
