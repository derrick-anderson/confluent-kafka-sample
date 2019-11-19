package com.solstice.example.confluentconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ConfluentConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfluentConsumerApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void logMessages(String message){
		System.out.println("Recieved message : " + message);
	}

}
