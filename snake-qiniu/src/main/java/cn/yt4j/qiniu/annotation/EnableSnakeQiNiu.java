package cn.yt4j.qiniu.annotation;

import cn.yt4j.qiniu.QiNiuAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author gyv12345
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({QiNiuAutoConfiguration.class})
public @interface EnableSnakeQiNiu {
}
