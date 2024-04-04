package com.example.demo.UserService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserEntity.UserEntity;
import com.example.demo.UserRepo.UserRepo;

@Service
public class UserService {
@Autowired
private UserRepo ur;
public List<UserEntity> getAllUsers() {
return ur.findAll();
}
public Optional<UserEntity> getUserById(int id) {
return ur.findById(id);
}
public List<UserEntity> createUser(List<UserEntity> user) {
return ur.saveAll(user);
}

public String updateUser(int id, UserEntity userDetails) {
Optional<UserEntity> optionalUser = ur.findById(id);
if (optionalUser.isPresent()) {
UserEntity user = optionalUser.get();
user.setName(userDetails.getName());
user.setEmail(userDetails.getEmail());
user.setAge(userDetails.getAge());
ur.save(user);
return "User updated successfully.";
} else {
return "User not found.";
}
}
public void deleteUser(int id) {
ur.deleteById(id);
}
}