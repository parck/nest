package cn.edots.nest.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    private DocumentationInfo documentationInfo;
    private String basePackage;
    private boolean enable;
    private DocumentationType documentationType;

    @Bean
    public Docket createRestApi() {
        return new Docket(this.documentationType == null ? DocumentationType.SPRING_WEB : this.documentationType)
                .enable(this.enable)
                .apiInfo(this.documentationInfo == null ? ApiInfo.DEFAULT : this.documentationInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage(this.basePackage))
                .paths(PathSelectors.any())
                .build();
    }

    public DocumentationInfo getDocumentationInfo() {
        return documentationInfo;
    }

    public void setDocumentationInfo(DocumentationInfo documentationInfo) {
        this.documentationInfo = documentationInfo;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public DocumentationType getDocumentationType() {
        return documentationType;
    }

    public void setDocumentationType(DocumentationType documentationType) {
        this.documentationType = documentationType;
    }
}
