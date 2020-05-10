package triana.demo.transformers.messages.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface CsvToJsonChannel {

    String SOURCE ="csv";
    String SINK="csv-to-json";
    @Input(SOURCE)
    SubscribableChannel csv();
    @Output(SINK)
    MessageChannel json();
}
