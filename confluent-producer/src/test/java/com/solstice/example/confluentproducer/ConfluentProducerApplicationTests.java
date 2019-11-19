package com.solstice.example.confluentproducer;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RunWith(SpringRunner.class)
class ConfluentProducerApplicationTests {

	@Autowired
	MessageCollector messageCollector;

	@Autowired
	Source source;

	@Test
	void contextLoads() {
	}

	@Test
	void generateMessages_shouldSendToOutput() throws InterruptedException {
		Thread.sleep( 5000L);
		Message savedMessage = messageCollector.forChannel(source.output()).poll(5, TimeUnit.SECONDS);

		assertThat(savedMessage.getPayload()).isNotNull();
	}
}
