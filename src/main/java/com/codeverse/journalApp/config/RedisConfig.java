package com.codeverse.journalApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

// if you don't provide this configuration, then your application won't pick data on your local Redis server & vice-versa. i.e., if you set something from your SB
// application, then it won't get stored in your Redis application & if you set something on your redis-cli, then also, it won't get queried in your SB application.
// due to the reason that the default serializer that your SB application uses is not same as the one that Redis uses.
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory factory){
        RedisTemplate redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());

        return redisTemplate;
    }

}
