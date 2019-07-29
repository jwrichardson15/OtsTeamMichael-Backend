package com.credera.parks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collection;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {
    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.credera.parks"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(getApiInfo());
    }

    public ApiInfo getApiInfo() {
        Collection<VendorExtension> vendorExtensions = Collections.emptyList();
        return new ApiInfo(
            "National Parks Service",
            "Services for National Parks",
            "0.0.1",    // TODO: should this be read from some env var/gradle setting?
            "",
            new Contact("Credera","","parksandrecreation@credera.com"),
            "",
            "",
            vendorExtensions
        );
    }
}
