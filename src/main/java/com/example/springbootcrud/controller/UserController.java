package com.example.springbootcrud.controller;

import com.example.springbootcrud.dto.ListUserDummyResponse;
import com.example.springbootcrud.dto.UserDummyNameRequest;
import com.example.springbootcrud.dto.UserDummyRequest;
import com.example.springbootcrud.dto.UserDummyResponse;
import com.example.springbootcrud.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String inquiryForm(Model model) {
        model.addAttribute("UserDummyRequest", new UserDummyRequest());
        return "createScreen";
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public String submitForm(@ModelAttribute("UserDummyRequest") UserDummyRequest request) throws Exception {
        //UserDummyResponse response = new UserDummyResponse();
        userService.saveUser(request);
        //model.addAttribute("UserDummyResponse", response);
        return "redirect:/users/list";
    }
    
    @GetMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable("id") int id) throws Exception {
        //UserDummyResponse response = new UserDummyResponse();
        userService.deleteUser(id);
        //model.addAttribute("UserDummyResponse", response);
        return "redirect:/users/list";
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public String showUser(Model model) throws Exception {
        ListUserDummyResponse responses = new ListUserDummyResponse();
        List<UserDummyResponse> response = new ArrayList<>();
        responses = userService.getUser();

        response = responses.getUserDummyResponses();
        if (response == null) {
            return "emptyScreen";
        } else {
            model.addAttribute("ListUserDummyResponse", response);
            model.addAttribute("UserDummyNameRequest", new UserDummyNameRequest());
            return "listScreen";
        }
    }

    @PostMapping(value = "/list/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public String sarchName(@ModelAttribute("UserDummyNameRequest") UserDummyNameRequest request, Model model) throws Exception {
        ListUserDummyResponse responses = new ListUserDummyResponse();
        List<UserDummyResponse> response = new ArrayList<>();
        responses = userService.getUserByName(request.getName());
        response = responses.getUserDummyResponses();
        model.addAttribute("ListUserDummyResponse", response);
        return "listScreen";
    }

}
