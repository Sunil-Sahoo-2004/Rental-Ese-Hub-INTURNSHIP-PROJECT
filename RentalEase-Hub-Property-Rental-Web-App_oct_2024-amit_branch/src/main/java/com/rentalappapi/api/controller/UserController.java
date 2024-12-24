package com.rentalappapi.api.controller;

import com.rentalappapi.api.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rentalappapi.api.model.UserIdRequest;
import com.rentalappapi.api.model.UserRequestBody;
import com.rentalappapi.api.service.UserService;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService UserService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserRequestBody UserReqBody) throws Exception {
        return ResponseEntity.ok(UserService.createUser(UserReqBody));
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody UserRequestBody UserReqBody) throws Exception {
        return ResponseEntity.ok(UserService.updateUser(UserReqBody));
    }

    @RequestMapping(value = "/listAllUsers", method = RequestMethod.GET)
    public ResponseEntity<?> listAllUsers(@RequestParam(defaultValue = "0") final Integer pageNumber,
                                               @RequestParam(defaultValue = "10") final Integer size) throws Exception {
        return ResponseEntity.ok(UserService.listallusersfromdb(pageNumber, size));
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<UserEntity> getUserById(@PathVariable int userId) {
        return ResponseEntity.ok(UserService.getUserById(userId));
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@RequestBody UserIdRequest user) throws Exception {
        return ResponseEntity.ok(UserService.deleteUser(user));
    }

    @RequestMapping(value = "/usersCount", method = RequestMethod.GET)
    public ResponseEntity<?> countNumberOfUsers() throws Exception {
        return ResponseEntity.ok((UserService.countNumberOfUsers()));
    }

}
