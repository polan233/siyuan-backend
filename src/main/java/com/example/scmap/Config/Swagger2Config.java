package com.example.scmap.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    private static final String BASE_PACKAGE1 = "com.example.scmap.controller";
    private static final String GROUP_NAME1 = "controller";
    private static final String BASE_PACKAGE2 = "com.example.scmap.entity";
    private static final String GROUP_NAME2 = "entity";
    private static final String BASE_PACKAGE3 = "com.example.scmap.dto";
    private static final String GROUP_NAME3 = "dto";
    private static final String TITLE = "API Documentation";
    private static final String DESCRIPTION = "思源接口文档";
    @Bean
    public Docket createControllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(GROUP_NAME1)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE1))//设定扫描范围
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createEntityApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(GROUP_NAME2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE2))//设定扫描范围
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createDtoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(GROUP_NAME3)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE3))//设定扫描范围
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version("1.0")
                .build();
    }
}
