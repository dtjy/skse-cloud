package com.skse.controller;

import com.skse.util.JwtUtil;
import com.skse.vo.LoginRespVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jiangyao
 * @Date 2021/2/8 10:43
 **/
@Slf4j
@RequestMapping(value = "/login")
@RestController
public class LoginController {

    @RequestMapping(value = "login")
    public Object login(String userId) throws Exception{
        try {
            String userName = JwtUtil.userMap.get(userId);
            if (userName==null){
                return "错误登录不存在";
            }
            //给分配一个token 然后返回
            String jwtToken = JwtUtil.sign(userId, userName);
            LoginRespVO loginRespVO = new LoginRespVO();
            loginRespVO.setToken(jwtToken);
            loginRespVO.setUserId(userId);
            loginRespVO.setUserName(userName);
            return loginRespVO;
        }catch (Exception e) {
            return e.getMessage();
        }
    }
}
