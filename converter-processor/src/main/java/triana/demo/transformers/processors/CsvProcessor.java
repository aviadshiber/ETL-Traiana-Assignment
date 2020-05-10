package triana.demo.transformers.processors;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import triana.demo.transformers.messages.channels.CsvToJsonChannel;
import triana.demo.transformers.messages.converters.CsvMessageConverter;
import triana.demo.transformers.messages.converters.CustomMessageConverter;

@EnableBinding(CsvToJsonChannel.class)
public class CsvProcessor {

    private final CustomMessageConverter messageConverter;

    public CsvProcessor() {
        this.messageConverter = new CsvMessageConverter();
    }

    @StreamListener(CsvToJsonChannel.SOURCE)
    @SendTo(CsvToJsonChannel.SINK)
    public String receive(String csv){
        return messageConverter.convert(csv);
    }
}
