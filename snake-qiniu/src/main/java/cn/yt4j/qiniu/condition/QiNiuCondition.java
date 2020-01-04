package cn.yt4j.qiniu.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

/**
 * @author gyv12345
 */
public class QiNiuCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String ak = context.getEnvironment().getProperty("snake.qiniu.access-key");
        String sk = context.getEnvironment().getProperty("snake.qiniu.secret-key");
        String bucketName = context.getEnvironment().getProperty("snake.qiniu.bucket-name");

        if (StringUtils.isEmpty(ak)) {
            throw new RuntimeException("Lack of qiniuyun configuration:access-key");
        } else if (StringUtils.isEmpty(sk)) {
            throw new RuntimeException("Lack of qiniuyun configuration:qiniu.secret-key");
        } else if (StringUtils.isEmpty(bucketName)) {
            throw new RuntimeException("Lack of qiniuyun configuration:qiniu.bucket-name");
        }else {
            return true;
        }
    }
}
