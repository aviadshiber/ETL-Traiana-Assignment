package triana.demo.xml.converter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import static org.junit.jupiter.api.Assertions.*;

class XmlConverterTest {

    public static final String EXPECTED = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<demoData>\n" +
            "    <id>1</id>\n" +
            "    <valid>true</valid>\n" +
            "</demoData>\n";

    @Builder
    @XmlRootElement
    @NoArgsConstructor
    @AllArgsConstructor
    private static class demoData{
        @XmlElement
        int id;
        @XmlElement
        boolean valid;
    }

    @Test
    void toXml() {
        XmlConverter xmlConverter=new XmlConverter();
        String dataXml = xmlConverter.toXml(demoData.builder().id(1).valid(true).build());
        assertEquals(EXPECTED,dataXml);
    }
}