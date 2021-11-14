package com.spg.wnc.config

import com.fasterxml.jackson.databind.json.JsonMapper
import com.nhaarman.mockitokotlin2.mock
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

@TestConfiguration
@Import(value = [WebConfig::class, SerializationConfig::class])
class TestWebConfig {
}