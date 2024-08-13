package com.example.exerciserepository.Repository;

import com.example.exerciserepository.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findUsersById(Integer id);
    Users findUsersByEmail(String email);
    List<Users> findUsersByRole(String role);
    @Query("select a from Users a where a.age>=?1")
    List<Users> getAgeAndAbove(int age);
    @Query("select p from Users p where p.username=?1 and p.password=?2")
    Users usernameAndPassword(String username,String password);
}
