package com.solstice.example.confluentproducer;

import org.apache.kafka.common.utils.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableBinding(Source.class)
@EnableScheduling
public class ConfluentProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfluentProducerApplication.class, args);
	}

	@Autowired
	Source source;

	@Scheduled(fixedRate = 500L)
	public void produceMessages(){
		source.output().send(MessageBuilder.withPayload("Generating Message with Timestamp : " + Time.SYSTEM).build());
	}

}
