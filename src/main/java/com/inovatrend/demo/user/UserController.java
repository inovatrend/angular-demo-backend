package com.inovatrend.demo.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserManager userManager;

    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }


    @ResponseBody
    @RequestMapping("/list")
    public List<User> listUsers(){
        return userManager.getUsers();
    }


    @ResponseBody
    @RequestMapping("/register")
    public User registerUser(@RequestParam String username, @RequestParam String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userManager.save(user);
    }

    @ResponseBody
    @RequestMapping("/save")
    public User saveUser(@RequestBody User user){
        return userManager.save(user);
    }


    @ResponseBody
    @RequestMapping("/delete")
    public Boolean delete(@RequestParam(required = false) Long userId, HttpServletRequest request){
        try {
            userManager.deleteUser(userId);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }
}
