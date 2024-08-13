package com.example.exerciserepository.Service;

import com.example.exerciserepository.Api.ApiExeption;
import com.example.exerciserepository.Model.Users;
import com.example.exerciserepository.Repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;

    public List<Users> getUser() {
        return userRepository.findAll();
    }
    public void addUser(Users users){

        userRepository.save(users);
    }
    public void updateUser(Integer id,Users users){
        Users u=userRepository.findUsersById(id);
        if(u==null){
            throw new ApiExeption("user not found");
        }
        u.setUsername(users.getUsername());
        u.setRole(users.getRole());
        u.setPassword(users.getPassword());
        u.setName(users.getName());
        u.setEmail(users.getEmail());
        u.setAge(users.getAge());
        userRepository.save(u);
    }

    public void deleteUser(Integer id){
        Users u=userRepository.findUsersById(id);
        if(u==null){
            throw new ApiExeption("user not found");
        }
        userRepository.delete(u);
    }

    //• Check if username and password are correct

    public Users getByUandP(String username ,String password){
      Users u=userRepository.usernameAndPassword(username,password);
        if(u==null){
            throw new ApiExeption("username or password not correct");
        }
        return u;
    }

    // Get user by email
    public Users GetUserByEmail(String email){
        Users u=userRepository.findUsersByEmail(email);
        if(u==null){
            throw new ApiExeption("email not found");
        }
        return u;
    }

//• Get All users with specific role
    public List<Users> getUserByRole(String role){
        List<Users> u=userRepository.findUsersByRole(role);
        if(u==null){
            throw new ApiExeption("not found");
        }
        return u;
    }

    //• Get All users with specific age or above
    public List<Users> getAgeAbove(int age){
        List<Users> u=userRepository.getAgeAndAbove(age);
        if(u==null){
            throw new ApiExeption("not found");
        }
        return u;
    }



}
