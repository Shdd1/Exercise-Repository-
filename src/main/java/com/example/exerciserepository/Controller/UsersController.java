package com.example.exerciserepository.Controller;

import com.example.exerciserepository.Model.Users;
import com.example.exerciserepository.Service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(usersService.getUser());
    }
    @PostMapping("/add")
    private ResponseEntity addUser(@Valid @RequestBody Users users, Errors errors){
        if(errors.hasErrors()){
            String massege=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        usersService.addUser(users);
        return ResponseEntity.status(200).body("is added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid@RequestBody Users users,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        usersService.updateUser(id,users);
        return ResponseEntity.status(200).body("user Updated");
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity deleteUser(@PathVariable Integer id){
        usersService.deleteUser(id);
        return ResponseEntity.status(200).body("user is deleted");
    }
    @GetMapping("gete/{email}")
    public ResponseEntity getUserByEmail(@PathVariable String email){

                return ResponseEntity.status(200).body(usersService.GetUserByEmail(email));
    }
    @GetMapping("/getr/{role}")
    public ResponseEntity getUserByRole(@PathVariable String role){
        return ResponseEntity.status(200).body(usersService.getUserByRole(role));
    }
    @GetMapping("/geta/{age}")
    public ResponseEntity getUserByRole(@PathVariable int age){
        return ResponseEntity.status(200).body(usersService.getAgeAbove(age));
    }
    @GetMapping("/getby/{username}/{password}")
    public ResponseEntity check(@PathVariable String username ,@PathVariable String password){
        return ResponseEntity.status(200).body(usersService.getByUandP(username,password));
    }

}
