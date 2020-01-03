package cn.yt4j.swagger.property;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author gyv12345
 */
@Data
@ConfigurationProperties(prefix = "snake.swagger")
public class SwaggerProperty {
    /**
     * the api controller basePackage
     */
    private String basePackage;
    /**
     * title
     */
    private String title;
    /**
     * contact
     */
    private Contact contact = new Contact();
    /**
     * version
     */
    private String version;
    /**
     * using swagger
     */
    private Boolean enabled = true;
    /**
     * description
     */
    private String description;

    @Data
    @NoArgsConstructor
    public static class Contact {

        /**
         * Contact name
         **/
        private String name = "";
        /**
         * Contact url
         **/
        private String url = "";
        /**
         * Contact email
         **/
        private String email = "";

    }
}
