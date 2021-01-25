package com.skse.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @Author jiangyao
 * @Date 2021/1/19 10:26
 **/
@Component
@Slf4j
public class TestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String body = StreamUtils.copyToString(request.getInputStream(), Charset.defaultCharset());
        log.info(body);
        chain.doFilter(request,response);
    }
}
