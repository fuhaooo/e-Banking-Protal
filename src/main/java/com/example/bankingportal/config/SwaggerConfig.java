package com.example.bankingportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2  
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                // 扫描哪个接口的包
                .apis(RequestHandlerSelectors.basePackage("com.example.bankingportal.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder()
                        .title("E-banking Portal API Service")
                        .description("desc: Qualification Test Backend Developer")
                        // 版本信息
                        .version("1.1.0")
                        // 开发文档的联系人
                        .contact(new Contact("Alfred", "https://www.synpulse.com/","fuhaojava@foxmail.com"))
                        .license("API规范")
                        .licenseUrl("API规范的URL")
                        .build());
    }
}