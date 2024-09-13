//package com.ceub.pi.effycityservice.config.swagger;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//
//@Configuration
//public class SwaggerConfigurations {
//
//    @Bean
//    public Docket modelServiceApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(getApiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.ceub.pi.effycityservice.controller"))
//                .paths(PathSelectors.ant("/**"))
//                .build();
//    }
//
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//
//    private ApiInfo getApiInfo() {
//        return new ApiInfoBuilder()
//                .title("Effycity API Doc")
//                .description("More description about the API")
////                .version("1.0.0")
//                .build();
//    }
//}
