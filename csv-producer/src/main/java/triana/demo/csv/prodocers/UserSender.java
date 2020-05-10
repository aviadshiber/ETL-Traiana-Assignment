package triana.demo.csv.prodocers;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@EnableBinding(Source.class)
@Slf4j
public class UserSender {

	private final Source source;
	private final String[] users = {"Eyal", "Aviv", "Guy", "Shahar", "Aviad"};

	@Autowired
	public UserSender(Source source) {

		this.source = source;
	}

	@Scheduled(fixedDelay = 1000)
	public void sendEvents() {
		val name=this.users[new Random().nextInt(5)];
		val data=new Random().nextInt(700);
		val csv = new StringBuilder()
				.append("name")
				.append(",")
				.append("data")
				.append("\n")
				.append(name)
				.append(",")
				.append(data).toString();
		val message= MessageBuilder
				.withPayload(csv)
				.setHeader("contentType","text/plain")
				.build();
		this.source.output().send(message);
	}

}
