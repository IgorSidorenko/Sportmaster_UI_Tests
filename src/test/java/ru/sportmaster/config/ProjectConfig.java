package ru.sportmaster.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentials.properties")
public interface ProjectConfig extends Config {
    String login();
    String password();
    String baseUrl();
    String browserSize();
    String browser();
    String browserVersion();
}