package com.example.test_end_01.controller;

import com.example.test_end_01.entity.pojo.RestBean;
import com.example.test_end_01.entity.pojo.User;
import com.example.test_end_01.service.UserService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")//注解用于定义这个控制器类中所有方法的公共路径前缀,这意味着这个控制器类中的所有方法的路径都会以 /api/user 开头
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("information")
    public RestBean<User> getMyInfo(HttpServletRequest request){//没有正确的令牌的话进不去，所以不用判断是不是空了
//        if(session.getAttribute("user")==null)return RestBean.failure(401,"未登陆~");
        User theUser=userService.getUserById((Integer) request.getAttribute("id"));
        theUser.setPassword(null);
        //获取键为user的值
        return RestBean.success("获取成功！",theUser);
    }

    @GetMapping("logout")
    public RestBean<String> logout(HttpSession session){
        if(session.getAttribute("user")==null)return RestBean.failure(401,"未登陆~");
        session.removeAttribute("user");
        session.invalidate();
        return RestBean.success("退出成功！");
    }
}
