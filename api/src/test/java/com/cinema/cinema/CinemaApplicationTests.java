package com.cinema.cinema;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CinemaApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(CinemaApplicationTests.class);

	@Test
	void contextLoads() {
		// This test is intentionally left empty.
		logger.info("Application context loaded successfully.");
	}

}
