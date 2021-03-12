//package com.skse.config.swagger;
//
//import org.springframework.context.annotation.Condition;
//import org.springframework.context.annotation.ConditionContext;
//import org.springframework.core.type.AnnotatedTypeMetadata;
//
///**
// * swagger自动注入开关，更具环境判定本地dev自动配置注入，云服务器pro关闭
// * @Author jiangyao
// * @Date 2020/7/1 15:40
// **/
//public class SwaggerCondition implements Condition {
//    @Override
//    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        if (context.getEnvironment().getProperty("spring.profiles.active").equals("pro")){
//            return Boolean.FALSE;
//        }
//        return Boolean.TRUE;
//    }
//}
