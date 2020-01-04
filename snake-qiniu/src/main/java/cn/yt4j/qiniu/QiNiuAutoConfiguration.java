package cn.yt4j.qiniu;

import cn.yt4j.qiniu.condition.QiNiuCondition;
import cn.yt4j.qiniu.property.QiNiuProperties;
import cn.yt4j.qiniu.service.QiNiuService;
import cn.yt4j.qiniu.service.impl.QiNiuServiceImpl;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author gyv12345
 */
@Slf4j
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties({QiNiuProperties.class})
@Conditional(QiNiuCondition.class)
@ConditionalOnProperty(name = "snake.qiniu.enabled", matchIfMissing = true)
public class QiNiuAutoConfiguration {
    @Autowired
    private QiNiuProperties qiNiuYunProperties;

    @Bean
    @ConditionalOnMissingBean(QiNiuServiceImpl.class)
    public QiNiuService qiNiuYunService() {
        return new QiNiuServiceImpl();
    }

    @Bean
    public UploadManager uploadManager() {
        com.qiniu.storage.Configuration conf=new com.qiniu.storage.Configuration(Zone.autoZone());
        return new UploadManager(conf);
    }

    @Bean
    public Auth auth() {
        return Auth.create(qiNiuYunProperties.getAccessKey(), qiNiuYunProperties.getSecretKey());
    }

    @Bean
    public BucketManager bucketManager() {
        com.qiniu.storage.Configuration conf=new com.qiniu.storage.Configuration(Zone.autoZone());
        return new BucketManager(auth(),conf);
    }
}


