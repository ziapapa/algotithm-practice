package kko;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class kt2 {

    public static void main(String[] args) throws IOException {

        // 3 apple, 2 banana, others 1
        List<Integer> items = Arrays.asList(3, 1, 2, 2, 4, 3);

        Map<Integer, Long> groupResult =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        Map<Integer, Long> linkMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        groupResult.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue()
                        ).forEachOrdered(e -> linkMap.put(e.getKey(), e.getValue()));

        System.out.println(linkMap);
        
        for (Entry<Integer, Long> set : linkMap.entrySet()) {
            for (int i = 0 ; i < set.getValue() ; i++) {
                System.out.println(set.getKey());
            }
        }
        
        

    }

}
