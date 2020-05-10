package triana.demo.xml.prodocers;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import triana.demo.xml.converter.XmlConverter;
import triana.demo.xml.domain.User;

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
	private final XmlConverter converter;
	private final String[] users = {"Eyal", "Aviv", "Guy", "Shahar", "Aviad"};

	@Autowired
	public UserSender(Source source,XmlConverter converter) {
		this.converter=converter;
		this.source = source;
	}

	@Scheduled(fixedDelay = 1000)
	public void sendEvents() {
		val user = User
				.builder()
				.name(this.users[new Random().nextInt(5)])
				.data(new Random().nextInt(700))
				.build();
		val message= MessageBuilder
				.withPayload(converter.toXml(user))
				.setHeader("contentType","text/plain")
				.build();
		this.source.output().send(message);
	}

}
