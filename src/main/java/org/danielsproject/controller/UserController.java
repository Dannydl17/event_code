//package org.danielsproject.controller;
//
//import lombok.AllArgsConstructor;
//import org.danielsproject.dtos.request.UserRegistrationRequest;
//import org.danielsproject.dtos.response.UserRegistrationResponse;
//import org.danielsproject.services.UserService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/v1/customer")
//@AllArgsConstructor
//public class UserController {
//    private final UserService userService;
//    @PostMapping
//    public ResponseEntity<UserRegistrationResponse> createCustomer(@RequestBody UserRegistrationRequest request){
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(userService.createUser(request));
//    }
//}
