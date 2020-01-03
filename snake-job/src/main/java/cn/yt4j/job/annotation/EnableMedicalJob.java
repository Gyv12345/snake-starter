package cn.yt4j.job.annotation;

import cn.yt4j.job.JobAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author shichenyang
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({JobAutoConfiguration.class})
public @interface EnableMedicalJob {
}
