package com.muhammed.thasneem.smartnytimeapp


import org.junit.Test
import java.io.IOException
import java.net.URL


class APIAvailabilityTest {
    @Test
    @Throws(IOException::class)
    fun testAvailability() {
        val connection = URL("https://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=Ld0AF7Vw0WXoTL5oGQSYPJGlb8PSrYrN").openConnection()
        val response = connection.getInputStream()
        val buffer = StringBuffer()
        val readText = response.bufferedReader().readText()
        assert(readText.isNotEmpty())
    }
}