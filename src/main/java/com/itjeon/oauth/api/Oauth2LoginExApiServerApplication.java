package com.itjeon.oauth.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.itjeon.oauth.api.config.prop.CorsProperties;

@SpringBootApplication
@EnableConfigurationProperties({
    CorsProperties.class
})
public class Oauth2LoginExApiServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2LoginExApiServerApplication.class, args);
	}

}
