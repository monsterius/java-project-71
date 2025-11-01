package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Utils.Reader;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String fileToProcess = Reader.readFile(file);
        return mapper.readValue(fileToProcess, Map.class);
    }
}
