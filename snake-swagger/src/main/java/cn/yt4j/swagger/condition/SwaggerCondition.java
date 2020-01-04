package cn.yt4j.swagger.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.StringUtils;

/**
 * @author gyv12345
 */
public class SwaggerCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String basePackage= context.getEnvironment().getProperty("snake.swagger.basePackage");
        if (StringUtils.isEmpty(basePackage)){
            throw new RuntimeException("basePackage is required");
        }
        return true;
    }
}
