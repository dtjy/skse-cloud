package com.skse.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@RibbonClient(name = "PAY-SERVICE", configuration = LoadBalanceRuleConfig.class)
public class LoadBalanceRuleConfig {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
