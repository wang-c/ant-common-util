/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-12-18 19:24 创建
 */
package org.antframework.common.util.query.annotation.operator;

import org.antframework.common.util.query.annotation.QueryParam;
import org.antframework.common.util.query.annotation.operator.support.NullQueryParamParser;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 等于null查询
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@QueryParam(parser = NullQueryParamParser.class)
public @interface QueryNull {
    /**
     * 属性名（默认为被注解标注的属性的名称）
     */
    @AliasFor(annotation = QueryParam.class, attribute = "attrName")
    String attrName() default "";
}
