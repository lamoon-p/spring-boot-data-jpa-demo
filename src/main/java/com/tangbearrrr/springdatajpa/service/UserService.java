package com.tangbearrrr.springdatajpa.service;

import com.tangbearrrr.springdatajpa.entity.User;
import com.tangbearrrr.springdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) throws Exception {
        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("Record Not Found"));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int id, User user) throws Exception {
        findById(id);
        User updateUser = new User();
        updateUser.setId(user.getId());
        updateUser.setName(user.getName());
        updateUser.setAge(user.getAge());
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

}
