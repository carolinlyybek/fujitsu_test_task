package com.fujitsu.exercise;

import com.fujitsu.exercise.feedback.FeedbackController;
import com.fujitsu.exercise.feedback.FeedbackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SmokeTests {

	@Autowired
	private FeedbackController controller;
	@Autowired
	private FeedbackService service;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(service).isNotNull();
	}



}
