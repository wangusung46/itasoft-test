package com.example.springbootcrud.service;

import com.example.springbootcrud.dto.ListUserDummyResponse;
import com.example.springbootcrud.dto.UserDummyRequest;
import com.example.springbootcrud.dto.UserDummyResponse;

/**
 * @author Riyad
 *
 */
public interface UserService {
    
    public void saveUser(UserDummyRequest user) throws Exception;
    
    public ListUserDummyResponse getUser() throws Exception;
    
    public ListUserDummyResponse getUserByName(String name) throws Exception;

    public void deleteUser(int id);

}
