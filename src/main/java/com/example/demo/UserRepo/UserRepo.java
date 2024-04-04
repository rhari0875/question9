package com.example.demo.UserRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.UserEntity.UserEntity;
@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer>{
@Query("SELECT u FROM UserEntity u WHERE u.id = :id")
UserEntity getUserById(int id);
}