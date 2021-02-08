package com.skse.vo;

import lombok.Data;

/**
 * @Author jiangyao
 * @Date 2021/2/8 10:52
 **/
@Data
public class LoginRespVO {

    private Object token;

    private String userName;
    private String userId;
}
