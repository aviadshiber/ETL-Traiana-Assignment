package triana.demo.transformers.messages.converters;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static triana.demo.transformers.consts.ConstUtils.XML_BODY_STRING;
import static triana.demo.transformers.consts.ConstUtils.XML_TO_JSON_EXPECTED_RESULT;


class XmlMessageConverterTest {

    @Test
    void testing_convert_from_xml_to_json() {
        val xmlMessageConverter = new XmlMessageConverter();
        val result=xmlMessageConverter.convert(XML_BODY_STRING);
        assertEquals(XML_TO_JSON_EXPECTED_RESULT,result);
    }
}