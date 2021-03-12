package com.skse.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author jiangyao
 * @Date 2020/5/29 21:20
 **/
//@Conditional(value = SwaggerCondition.class)
@Profile(value = {"dev"})  //环境判断，dev环境该类Bean注入生效
@Configuration //环境判断，dev环境该类Bean注入生效
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //指定需要扫描的controller
                .apis(RequestHandlerSelectors.basePackage("com.skse.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建文档基本信息，用于页面显示，可以包含版本、
     * 联系人信息、服务地址、文档描述信息等
     * @return ApiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //标题
                .title("speakshake-client RESTful APIs")
                //设置联系方式
                .contact(new Contact("speakshake-swagger", "给我打钱", "279964527@qq.com"))
                .version("1.0")
                .build();
    }
}
