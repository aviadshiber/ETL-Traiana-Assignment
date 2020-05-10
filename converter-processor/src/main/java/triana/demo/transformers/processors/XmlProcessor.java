package triana.demo.transformers.processors;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import triana.demo.transformers.messages.channels.XmlToJsonChannel;
import triana.demo.transformers.messages.converters.CustomMessageConverter;
import triana.demo.transformers.messages.converters.XmlMessageConverter;

@EnableBinding(XmlToJsonChannel.class)
public class XmlProcessor {

    private final CustomMessageConverter messageConverter;

    public XmlProcessor() {
        this.messageConverter = new XmlMessageConverter();
    }

    @StreamListener(XmlToJsonChannel.SOURCE)
    @SendTo(XmlToJsonChannel.SINK)
    public String receive(String csv){
        return messageConverter.convert(csv);
    }
}
