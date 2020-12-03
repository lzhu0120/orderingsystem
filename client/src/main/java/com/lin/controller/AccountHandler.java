package com.lin.controller;

import com.lin.entity.Admin;
import com.lin.entity.User;
import com.lin.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    AccountFeign accountFeign;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Object object = accountFeign.login(username, password, type);
        //object是linkedhashmap类型，不能强转成user
        LinkedHashMap<String, Object> hashMap = (LinkedHashMap)object;
        String result = null;
        long id = 0L;
        if(object == null){
            result = "login";
        } else{
            switch (type){
                case "user":
                    User user = new User();
                    id = ((Number)hashMap.get("id")).longValue();//int can't be cast to long directly
                    user.setId(id);
                    user.setNickname((String) hashMap.get("nickname"));
                    session.setAttribute("user", user);
                    result = "index";
                    break;
                case "admin":
                    Admin admin = new Admin();
                    id = ((Number)hashMap.get("id")).longValue();
                    admin.setId(id);
                    admin.setUsername((String) hashMap.get("username"));
                    session.setAttribute("admin", admin);
                    result = "main";
                    break;
            }
        }
        return result;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
}
