package cn.enterprisesite.support.persistence;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * MyBatis标识接口
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisDao {

	String value() default "";

}