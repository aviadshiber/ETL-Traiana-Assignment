package triana.demo.transformers.messages.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface XmlToJsonChannel {

    String SOURCE="xml";
    String SINK="xml-to-json";
    @Input(SOURCE)
    SubscribableChannel xml();
    @Output(SINK)
    MessageChannel json();
}
