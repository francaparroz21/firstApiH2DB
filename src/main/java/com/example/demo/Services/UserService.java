package com.example.demo.Services;

import com.example.demo.Repositories.UserRepository;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserServiceIn {

    @Autowired
    UserRepository repository;

    @Override
    public User saveUser(User u) {
        return repository.save(u);
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public User userModify(Long id,User u) {
        User userFinded = repository.findById(id).get();
        userFinded.setName(u.getName());
        userFinded.setLastName(u.getLastName());
        userFinded.setPhoneNumber(u.getPhoneNumber());
        userFinded.setMail(u.getMail());
        return repository.save(userFinded);
    }
    public User passModify(Long id,String pass) {
        User userFinded = repository.findById(id).get();
        userFinded.setPass(pass);
        return repository.save(userFinded);
    }

    @Override
    public boolean deleteUser(Long id) {
        try{
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
