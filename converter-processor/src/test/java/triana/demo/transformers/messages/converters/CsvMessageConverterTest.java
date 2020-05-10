package triana.demo.transformers.messages.converters;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static triana.demo.transformers.consts.ConstUtils.CSV_BODY_STRING;
import static triana.demo.transformers.consts.ConstUtils.CSV_TO_JSON_EXPECTED_RESULT;

class CsvMessageConverterTest {



    @Test
    void convert() {
        val csvMessageConverter=new CsvMessageConverter();
        val result=csvMessageConverter.convert(CSV_BODY_STRING);
        assertEquals(CSV_TO_JSON_EXPECTED_RESULT,result);
    }
}