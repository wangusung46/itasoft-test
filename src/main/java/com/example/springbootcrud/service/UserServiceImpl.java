package com.example.springbootcrud.service;

import com.example.springbootcrud.dto.ListUserDummyResponse;
import com.example.springbootcrud.dto.UserDummyRequest;
import com.example.springbootcrud.dto.UserDummyResponse;
import com.example.springbootcrud.entity.User;
import com.example.springbootcrud.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(UserDummyRequest request) throws Exception {
        User user = new User();
        user.setAlamat(request.getAlamat());
        user.setEmail(request.getEmail());
        user.setHp(request.getHp());
        user.setName(request.getName());

        userRepository.save(user);
    }

    @Override
    public ListUserDummyResponse getUser() throws Exception {
        ListUserDummyResponse response = new ListUserDummyResponse();
        List<UserDummyResponse> responses = new ArrayList<>();
//        List<User> users = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user : users) {
            UserDummyResponse list = new UserDummyResponse();
            list.setId(user.getId());
            list.setAlamat(user.getAlamat());
            list.setEmail(user.getEmail());
            list.setHp(user.getHp());
            list.setName(user.getName());
            responses.add(list);
        }
        response.setUserDummyResponses(responses);

        return response;
    }

    @Override
    public ListUserDummyResponse getUserByName(String name) throws Exception {
        ListUserDummyResponse response = new ListUserDummyResponse();
        List<UserDummyResponse> responses = new ArrayList<>();
        List<User> users = new ArrayList<>();
        users = userRepository.findByName(name);
        for (User user : users) {
            UserDummyResponse list = new UserDummyResponse();
            list.setAlamat(user.getAlamat());
            list.setEmail(user.getEmail());
            list.setHp(user.getHp());
            list.setName(user.getName());
            responses.add(list);
        }
        response.setUserDummyResponses(responses);

        return response;
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
