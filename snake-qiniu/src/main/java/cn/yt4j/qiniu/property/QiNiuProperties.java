package cn.yt4j.qiniu.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author gyv12345
 */
@Data
@Component
@ConfigurationProperties(prefix = "snake.qiniu")
public class QiNiuProperties {

    /**
     * accessKey
     */
    private String accessKey = "";
    /**
     * secretKey
     */
    private String secretKey = "";
    /**
     * bucketName
     */
    private String bucketName = "";
    /**
     * default cdn
     */
    private String cdnPrefix = "cdn";
    /**
     *  is enabled
     */
    private boolean enabled=true;
}
