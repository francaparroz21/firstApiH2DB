package com.example.demo.Controller;
import com.example.demo.Services.UserService;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    UserService service;

    @GetMapping
    public List<User> getUsers(){
        return service.getUsers();
    }

    @PostMapping
    public User saveUser(@RequestBody User u){
        return service.saveUser(u);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return service.getUser(id);
    }

    @PostMapping("/{id}")
    public User userModify(@PathVariable("id") Long id, @RequestBody User u){
        return service.userModify(id,u);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable("id") Long id){
        return service.deleteUser(id);
    }

    @PatchMapping("/{id}")
    public User passModify(@PathVariable("id") Long id,String pass){
        return service.passModify(id,pass);
    }
}
