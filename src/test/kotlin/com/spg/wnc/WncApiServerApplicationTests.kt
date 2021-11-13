package com.spg.wnc

import com.spg.wnc.config.TestWebConfig
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@SpringBootTest
@Import(value = [TestWebConfig::class])
class WncApiServerApplicationTests {
    @Test
    fun `Initialize Bean Test`() {
        main(arrayOf())
    }
}
