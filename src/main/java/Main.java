import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*- считать файл в Map c помощью Jackson

 - посчитать сумму значений из map (sum)

 - с помощью collections stream преобразовать в новую Map, где все значения умножены на sum

 - с помощью collections stream посчитать количество уникальных значений в мапе


*/
public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(
                Main.class.getResourceAsStream("properties.json"),
                HashMap.class);

        Map<String, Double> doubleResult =  new HashMap<>();
        for (Map.Entry<String, Object> element : result.entrySet()) {
            doubleResult.put(element.getKey(),Double.valueOf( element.getValue().toString()));
        }

        Double sum = 0d;

        for (Map.Entry<String, Double> element : doubleResult.entrySet()) {
            sum+=element.getValue();
        }

        System.out.println("Sum: " + sum);
    }
}
