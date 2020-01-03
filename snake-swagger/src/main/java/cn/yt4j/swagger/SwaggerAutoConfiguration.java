
package cn.yt4j.swagger;


import cn.yt4j.swagger.property.SwaggerProperty;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gyv12345
 */
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
@EnableConfigurationProperties({SwaggerProperty.class})
@ConditionalOnProperty(name = "medical.swagger.enabled", matchIfMissing = true)
public class SwaggerAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SwaggerProperty swaggerProperty() {
        return new SwaggerProperty();
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperty().getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swaggerProperty().getTitle())
                .contact(new Contact(swaggerProperty().getContact().getName(), swaggerProperty().getContact().getUrl(), swaggerProperty().getContact().getEmail()))
                .version(swaggerProperty().getVersion())
                .description(swaggerProperty().getDescription())
                .build();
    }

}
