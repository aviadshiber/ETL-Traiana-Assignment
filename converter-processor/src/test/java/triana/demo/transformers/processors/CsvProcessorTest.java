package triana.demo.transformers.processors;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.support.MessageBuilder;
import triana.demo.transformers.messages.channels.CsvToJsonChannel;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static triana.demo.transformers.consts.ConstUtils.*;

@SuppressWarnings("ALL")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CsvProcessorTest {
    @Autowired
    CsvToJsonChannel processor;

    @Autowired
    MessageCollector messageCollector;

    @Test
    public void contextLoads() {
    }

    @Test
    void receive() throws InterruptedException {
        this.processor.csv().send(
                MessageBuilder.
                        withPayload(CSV_BODY_STRING)
                        .setHeader("contentType", "text/plain")
                        .build()
        );
        val message = this.messageCollector
                .forChannel(processor.json())
                .poll(1, TimeUnit.SECONDS);
        assertNotNull(message);
        assertEquals(CSV_TO_JSON_EXPECTED_RESULT,message.getPayload().toString());
    }
}