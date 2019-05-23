package part1;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
// - с помощью collections stream преобразовать в новую Map, где все значения умножены на sum
        final double sum2 = sum;

        Map<String, Double> doubleResult2 =  new HashMap<>();
        doubleResult.entrySet().stream().forEach(v -> doubleResult2.put(v.getKey(),v.getValue()*sum2));

        doubleResult2.entrySet().forEach(v-> System.out.println(v));

//        с помощью collections stream посчитать количество уникальных значений в мапе

        Set<Double> uniqueValues = new HashSet<>();
        System.out.println("Unique value number " + doubleResult.entrySet().stream().map(v -> uniqueValues.add(v.getValue())).toArray().length);

    }
}
