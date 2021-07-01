package com.basis.colatina.documentmanager.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "minio")
@Configuration
@Getter
@Setter
public class ApplicationProperties {
    private String username;
    private String password;
    private String bucket;
    private String url;
}
