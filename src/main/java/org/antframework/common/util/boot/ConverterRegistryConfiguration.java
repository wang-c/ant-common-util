/* 
 * 作者：钟勋 (e-mail:zhongxunking@163.com)
 */

/*
 * 修订记录:
 * @author 钟勋 2017-06-12 18:16 创建
 */
package org.antframework.common.util.boot;

import org.antframework.common.util.money.MoneyConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterRegistry;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 转换器注册配置类
 */
@Configuration
public class ConverterRegistryConfiguration {
    // 本工具所有的converter
    private static final List<Converter> CONVERTERS;

    static {
        CONVERTERS = new ArrayList<>();
        CONVERTERS.addAll(MoneyConverters.getConverters());
    }

    @Autowired(required = false)
    private List<ConverterRegistry> converterRegistries;

    // 初始化（将本工具内的所有converter注册到所有converter注册器中）
    @PostConstruct
    public void init() {
        if (converterRegistries == null) {
            return;
        }
        for (ConverterRegistry registry : converterRegistries) {
            for (Converter converter : CONVERTERS) {
                registry.addConverter(converter);
            }
        }
    }
}
