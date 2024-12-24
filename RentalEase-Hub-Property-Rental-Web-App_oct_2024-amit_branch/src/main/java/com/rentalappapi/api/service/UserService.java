package com.rentalappapi.api.service;

import com.rentalappapi.api.entity.UserEntity;
import com.rentalappapi.api.model.UserIdRequest;
import com.rentalappapi.api.model.UserRequestBody;
import com.rentalappapi.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private UserRepository UserRepository;

    public UserEntity createUser(UserRequestBody userRequestBodyObj) {
        UserEntity newUser = new UserEntity();
        newUser.setFirstName(userRequestBodyObj.getFirstName());
        newUser.setLastName(userRequestBodyObj.getLastName());
        newUser.setEmail(userRequestBodyObj.getEmail());
        newUser.setPassword(userRequestBodyObj.getPassword());
        newUser.setPhoneNumber(userRequestBodyObj.getPhoneNumber());
        newUser.setUserType(userRequestBodyObj.getUserType());
        return UserRepository.save(newUser);
    }

    public UserEntity updateUser(UserRequestBody userRequestBodyObj) {
        UserEntity newUser = new UserEntity();
        newUser.setUserId(userRequestBodyObj.getUserId());
        newUser.setFirstName(userRequestBodyObj.getFirstName());
        newUser.setLastName(userRequestBodyObj.getLastName());
        newUser.setEmail(userRequestBodyObj.getEmail());
        newUser.setPassword(userRequestBodyObj.getPassword());
        newUser.setPhoneNumber(userRequestBodyObj.getPhoneNumber());
        newUser.setUserType(userRequestBodyObj.getUserType());
        return UserRepository.save(newUser);
    }

    public Page<UserEntity> listallusersfromdb(int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        return UserRepository.listallusersfromdb(pageable);
    }

    public UserEntity getUserById(int userId) {
        return UserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    public String deleteUser(UserIdRequest user) {
        int UserId = user.getUserId();
        UserRepository.deleteById(UserId);
        return "User Deleted";
    }

    public String countNumberOfUsers() {
        return UserRepository.countNumberOfUser();
    }

}
