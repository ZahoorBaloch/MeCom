package com.micro.MeCom

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MeComSeleniumTest {

	@LocalServerPort
	private var port: Int = 0

	private lateinit var driver: ChromeDriver

	@BeforeEach
	fun setUp() {
		val options = ChromeOptions()
		options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu")
		driver = ChromeDriver(options)
	}

	@AfterEach
	fun tearDown() {
		driver.quit()
	}

	@Test
	fun homePageDisplaysWelcomeMessage() {
		driver.get("http://localhost:$port/")

		assertEquals("MeCom", driver.title)
		assertEquals("Welcome to MeCom", driver.findElement(By.tagName("h1")).text)
		assertEquals("Application is running", driver.findElement(By.id("status")).text)
	}
}
