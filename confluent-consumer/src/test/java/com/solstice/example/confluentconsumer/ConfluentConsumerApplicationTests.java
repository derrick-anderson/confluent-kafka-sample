package com.solstice.example.confluentconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ConfluentConsumerApplicationTests {

	@Autowired
	Sink sink;

	@Test
	void contextLoads() {
	}

	@Test
	void logsMessagesSuccessfully() throws InterruptedException {
		sink.input().send(MessageBuilder.withPayload("TESTING").build());
		Thread.sleep(500L);
	}
}
