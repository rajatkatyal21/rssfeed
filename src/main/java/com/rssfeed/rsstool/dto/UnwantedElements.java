package com.rssfeed.rsstool.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "unwanted")
@Data
@Component
public class UnwantedElements {
	private String elements;
}
