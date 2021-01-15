//package com.skse.feign;
//
//import com.netflix.hystrix.util.Exceptions;
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//
///**
// * @Author jiangyao
// * @Date 2021/1/15 17:55
// **/
//@Slf4j
//public class AccountFeignErrorDecoder implements ErrorDecoder {
//
//    @Override
//    public Exception decode(String s, Response response) {
//        log.info("feign client response:", response);
//        String body = null;
//        try {
//            body = response.body().asReader().toString();
//        } catch (IOException e) {
//            log.error("feign.IOException", e);
//        }
//        if (response.status() >= 400 && response.status() <= 500) {
//            throw Exception;
//        }
//        return errorStatus(methodKey, response);
//    }
//}
//package com.skse.feign;
//
//import com.netflix.hystrix.util.Exceptions;
//import feign.Response;
//import feign.codec.ErrorDecoder;
//import lombok.extern.slf4j.Slf4j;
//
//import java.io.IOException;
//
///**
// * @Author jiangyao
// * @Date 2021/1/15 17:55
// **/
//@Slf4j
//public class AccountFeignErrorDecoder implements ErrorDecoder {
//
//    @Override
//    public Exception decode(String s, Response response) {
//        log.info("feign client response:", response);
//        String body = null;
//        try {
//            body = response.body().asReader().toString();
//        } catch (IOException e) {
//            log.error("feign.IOException", e);
//        }
//        if (response.status() >= 400 && response.status() <= 500) {
//            throw Exception;
//        }
//        return errorStatus(methodKey, response);
//    }
//}
