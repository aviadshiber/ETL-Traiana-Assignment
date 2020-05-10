package triana.demo.csv;

import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserSenderTests {

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private MessageCollector messageCollector;

	@Autowired
	private Source source;
	@Test
	public void contextLoads() {
	}
	@Test
	public void testUserSender() throws Exception {
		val message = this.messageCollector
				.forChannel(source.output())
				.poll(1, TimeUnit.SECONDS);
		assert message != null;
		String userPayload = message.getPayload().toString();
		assertTrue(userPayload.contains("name,data\n"));
	}


}
