package com.skse.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;

/**
 * @Author jiangyao
 * @Date 2021/2/7 16:00
 **/
public class JwtUtil {

    public static HashMap<String,String> userMap = new HashMap<String,String>();

    static {
        userMap.put("1","AAA");
        userMap.put("2","BBB");
        userMap.put("3","CCC");
        userMap.put("4","DDD");
    }

    /**
     * 过期时间5分钟
     */
    private static final long EXPIRE_TIME = 5 * 60 * 1000;

    /**
     * jwt 密钥
     */
    private static final String SECRET = ")(OIKJmn";

    /**
     * 生成签名，五分钟后过期
     * @param userId
     * @return
     */
    public static String sign(String userId, String userName)throws Exception{
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET+userId);
        return JWT.create()
                .withAudience(userId)
                .withIssuedAt(new Date())
                .withExpiresAt(date)  //有效时间
                .withClaim("userName", userName)    //载荷，随便写几个都可以
                .sign(algorithm);   //加密
    }
    /**
     * 检验合法性，其中secret参数就应该传入的是用户的id
     * @param token
     */
    public static Boolean checkSign(String token, String userId) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET+userId)).build();
            jwt = verifier.verify(token);
            return Boolean.TRUE;
        } catch (Exception e) {
            //抛出校验失败自定义异常
            throw new RuntimeException("token 无效，请重新获取");
        }
    }

    /**
     * 获取签发对象
     */
    public static String getAudience(String token) {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            //这里是token解析失败
            throw new RuntimeException("获取不到签发对象");
        }
        return audience;
    }

    /**
     * 通过载荷名字获取载荷的值
     */
    public static Claim getClaimByName(String token, String name){
        return JWT.decode(token).getClaim(name);
    }
}

