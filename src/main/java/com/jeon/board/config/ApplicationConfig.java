package com.jeon.board.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "com.jeon.board.dao", "com.jeon.board.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {

}