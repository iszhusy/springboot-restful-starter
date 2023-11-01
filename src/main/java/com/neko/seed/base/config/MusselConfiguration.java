package com.neko.seed.base.config;

import com.bytedance.ea.mussel.MusselConfig;
import com.bytedance.ea.saas.aep.utils.YmlPropertySource;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.K;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @Author: zhusiyuan.nn@bytedance.com
 * @Date: 2023/7/20 19:26
 * @Version: v1.0.0
 * @Description: TODO
 **/

//@Configuration
//@EnableConfigurationProperties(MusselConfig.class)
//@PropertySource(value = "classpath:/application.yml", factory = YmlPropertySource.class, encoding = "utf-8")
//@ConfigurationProperties(prefix = "ea.mussel")
public class MusselConfiguration {

    private static final boolean enabled = true;
    private static final String appID = "";
    private static final String secret = "";
    private static final String env = "boe";
    private static final String tosChannelId = "boe";

//    @Bean
//    public EbsProperty getConfiguredEbsProperties(
//            Environment env,
//            EbsProperties properties
//    ) {
//        for (EbsProperty property : properties.getPropertyList()) {
//            if (Objects.equals(System.getenv(ENV_SIM_PRD), Boolean.TRUE.toString())
//                    && Objects.equals(property.getProfile(), PRD_PROFILE)) {
//                // 仿真环境集群，使用线上ebs交叉验证，但是推送需使用pre ebs环境
//                return property;
//            }
//
//            if (Stream.of(env.getActiveProfiles())
//                    .anyMatch(p -> StringUtils.equalsIgnoreCase(p, property.getProfile().toLowerCase()))) {
//                return property;
//            }
//        }
//        throw new RuntimeException("Unable to create mdm config, profiles=" + Arrays.toString(env.getActiveProfiles()));
//    }
}
