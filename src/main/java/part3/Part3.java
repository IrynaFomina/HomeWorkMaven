package part3;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Part3 {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(
                Part3.class.getResourceAsStream("properties.json"),
                LinkedHashMap.class);

        result.entrySet().forEach(v-> System.out.println(v));
    }
}
