package com.spg.wnc.config

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

@TestConfiguration
@Import(value = [WebConfig::class])
class TestWebConfig {

}