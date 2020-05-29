package com.xyj.project.loginController;

import com.xyj.project.pojo.User;
import com.xyj.project.result.Result;
import com.xyj.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@Controller
public class LoginConttroller {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    @ResponseBody
    public Result login(@RequestBody User user) {
        String username = user.getUsername();
        username = HtmlUtils.htmlEscape(username);
//        if (!Objects.equals("admin", username) || !Objects.equals("123456", user.getPassword())) {
//            String message = "账号密码出错";
//            System.out.println("test");
//            return new Result(400);
//        } else {
//            return new Result(200);
//        }
        User user1 = userService.get(username, user.getPassword());
        if (null == user1) {
            return new Result(400, "账号密码出错");
        } else {
            return new Result(200, "登录成功");
        }

    }
}
