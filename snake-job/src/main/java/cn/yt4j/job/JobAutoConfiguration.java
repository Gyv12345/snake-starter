package cn.yt4j.job;

import cn.yt4j.job.property.JobProperty;
import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shichenyang
 */
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties({JobProperty.class})
@ConditionalOnProperty(name = "medical.job.enabled", matchIfMissing = true)
@Slf4j
public class JobAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public JobProperty jobProperty() {
        return new JobProperty();
    }

    @Bean(initMethod = "start", destroyMethod = "destroy")
    public XxlJobSpringExecutor xxlJobExecutor() {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(jobProperty().getAdminAddresses());
        xxlJobSpringExecutor.setAppName(jobProperty().getAppName());
        xxlJobSpringExecutor.setIp(jobProperty().getIp());
        xxlJobSpringExecutor.setPort(jobProperty().getPort());
        xxlJobSpringExecutor.setAccessToken(jobProperty().getAccessToken());
        xxlJobSpringExecutor.setLogPath(jobProperty().getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays(jobProperty().getLogRetentionDays());

        return xxlJobSpringExecutor;
    }
}
