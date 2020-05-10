package triana.demo.transformers.processors;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.support.MessageBuilder;
import triana.demo.transformers.messages.channels.XmlToJsonChannel;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static triana.demo.transformers.consts.ConstUtils.XML_BODY_STRING;
import static triana.demo.transformers.consts.ConstUtils.XML_TO_JSON_EXPECTED_RESULT;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class XmlProcessorTest {

    @Autowired
    private XmlToJsonChannel processor;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MessageCollector messageCollector;

    @Test
    public void contextLoads() {
    }

    @Test
    void receive() throws InterruptedException {
        this.processor.xml().send(
                MessageBuilder
                        .withPayload(XML_BODY_STRING)
                        .setHeader("contentType","text/plain")
                        .build()
        );
        val message = this
                .messageCollector
                .forChannel(processor.json())
                .poll(1, TimeUnit.SECONDS);
        assertNotNull(message);
        assertEquals(XML_TO_JSON_EXPECTED_RESULT,message.getPayload().toString());
    }
}