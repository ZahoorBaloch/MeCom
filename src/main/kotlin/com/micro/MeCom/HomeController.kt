package com.micro.MeCom

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

	@GetMapping("/")
	@ResponseBody
	fun home(): String = """
		<!DOCTYPE html>
		<html lang="en">
		<head>
			<meta charset="UTF-8">
			<title>MeCom</title>
		</head>
		<body>
			<h1>Welcome to MeCom</h1>
			<p id="status">Application is running</p>
		</body>
		</html>
	""".trimIndent()
}
