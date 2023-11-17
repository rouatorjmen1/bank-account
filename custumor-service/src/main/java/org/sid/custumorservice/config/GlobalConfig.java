package org.sid.custumorservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;


@ConfigurationProperties(prefix = "global.params") // il faut ajouter une anntation ds l'app springboot
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class GlobalConfig{
        int p1;
        int p2;



}
