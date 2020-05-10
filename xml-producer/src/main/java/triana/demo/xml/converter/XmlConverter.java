package triana.demo.xml.converter;


import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Slf4j
@Service
@NoArgsConstructor
public class XmlConverter {
    public String toXml(Object data){
        String xml = "";
        try {
            log.info("Generating xml for: " + data.getClass());
            JAXBContext jaxbContext = JAXBContext.newInstance(data.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //jaxbMarshaller.marshal(data, System.out);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(data, sw);
            xml = sw.toString();
        } catch (JAXBException e) {
            log.error(e.toString());
        }
        return xml;
    }
}
