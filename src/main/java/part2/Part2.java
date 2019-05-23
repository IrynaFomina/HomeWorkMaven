package part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/* 2) сгенерировать 100 000 случайных чисел, сохранить в list, посчитать максимум, количество уникальных значений
*/
public class Part2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        int minValue = 1;
        int maxValue = 5001;
        int numver = 100000;

        for (int i = 0; i < numver; i++) {
            list.add(random.nextInt(maxValue-minValue)+minValue);
        }

        System.out.println("Max value: " + (Collections.max(list)));
        System.out.println("Unique value number : " + list.stream().distinct().count());
    }
}
