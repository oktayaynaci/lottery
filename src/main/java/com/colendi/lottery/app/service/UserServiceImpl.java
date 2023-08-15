package com.colendi.lottery.app.service;

import com.colendi.lottery.app.data.models.User;
import com.colendi.lottery.app.data.payloads.request.UserRequest;
import com.colendi.lottery.app.data.payloads.response.MessageResponse;
import com.colendi.lottery.app.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public MessageResponse createUser(UserRequest userRequest) {
        User newUser = new User();
        newUser.setFirstName(userRequest.getFirstName());
        newUser.setLastName(userRequest.getLastName());
        newUser.setEmail(userRequest.getEmail());
        userRepository.save(newUser);
        return new MessageResponse("New user created successfully");
    }
    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getASingleUser(Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
