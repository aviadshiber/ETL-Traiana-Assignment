package triana.demo.transformers.messages.converters;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

@Slf4j
public class XmlMessageConverter implements CustomMessageConverter {
    private final static int PRETTY_PRINT_INDENT_FACTOR=4;

    @Override
    public String convert(String from) {
        try {
            JSONObject xmlJSONObj = XML.toJSONObject(from);
            return xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
        }catch (JSONException je){
            log.error(je.toString());
            throw je;
        }
    }
}
