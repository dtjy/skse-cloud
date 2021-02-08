package com.skse.config;

import cn.hutool.json.JSONUtil;
import com.skse.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @Author jiangyao
 * @Date 2021/2/8 10:03
 **/
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(">>>>>>>>>>>jwt拦截");
        // 从请求头中取出 token  这里需要和前端约定好把jwt放到请求头一个叫token的地方
        String token = request.getHeader("token");
        if (token == null){
            //重置response
            response.reset();
            //设置编码格式
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            pw.print("请先登录");
            pw.flush();
            pw.close();
            return Boolean.FALSE;
        }

        // 获取 token 中的 user Name
        String userId = JwtUtil.getAudience(token);
        //判断是否存在
        String userName = JwtUtil.userMap.get(userId);
        if (null == userName){
            //重置response
            response.reset();
            //设置编码格式
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            pw.print("用户不存在");
            pw.flush();
            pw.close();
            return Boolean.FALSE;
        }
        // 验证 token

        try {
            JwtUtil.checkSign(token, userId);
        } catch (Exception e) {
            //重置response
            response.reset();
            //设置编码格式
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            pw.print("token错误");
            pw.flush();
            pw.close();
            return Boolean.FALSE;
        }
        //获取载荷内容
        String tokenUserName = JwtUtil.getClaimByName(token, "userName").asString();
        log.info(">>>>>>>>>tokenUserName：{}",tokenUserName);
        return true;
    }
}
