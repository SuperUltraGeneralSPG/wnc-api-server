package com.spg.wnc.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SerializationConfig {
    @Bean
    fun jsonMapper(): JsonMapper {
        val builder = JsonMapper.builder()
        builder.addModule(KotlinModule())
        builder.addModule(JavaTimeModule())
        builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
        builder.serializationInclusion(JsonInclude.Include.NON_NULL)
        builder.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
        builder.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
        builder.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

        return builder.build()
    }
}