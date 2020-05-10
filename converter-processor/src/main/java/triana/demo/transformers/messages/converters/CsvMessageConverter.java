package triana.demo.transformers.messages.converters;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

@Slf4j
public class CsvMessageConverter implements CustomMessageConverter{
    @Override
    public String convert(String from) {
        try {
            val model = modelFromCsv(from);
            val mapper = new ObjectMapper();
            return mapper.writeValueAsString(model);
        } catch (IOException e) {
            log.error(e.toString());
            e.printStackTrace();
            throw new RuntimeException(e.toString());
        }
    }
    private List<Map<?, ?>> modelFromCsv(String input) throws IOException {
        val reader = new StringReader(input);
        val csvMapper = new CsvMapper();
        CsvSchema bootstrap = CsvSchema.emptySchema().withHeader();
        MappingIterator<Map<?, ?>> mappingIterator = csvMapper
                .reader(Map.class)
                .with(bootstrap)
                .readValues(reader);

        return mappingIterator.readAll();
    }
}
