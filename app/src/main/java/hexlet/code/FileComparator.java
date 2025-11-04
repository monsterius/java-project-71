package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileComparator {
    public static List<Map<String, Object>> compare(Map<String, Object> map1, Map<String, Object> map2) {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> sameLine = new HashMap<>();
        Map<String, Object> removedLine = new HashMap<>();
        Map<String, Object> newLine = new HashMap<>();
        map1.forEach((key, value) -> {
           if (map2.containsKey(key)) {
               if (value.equals(map2.get(key))) {
                   sameLine.put(key, value);
                   map2.remove(key);
               } else {
                   removedLine.put(key, value);
                   newLine.put(key, map2.get(key));
                   map2.remove(key);
               }
           } else  {
               removedLine.put(key, value);
           }
        });
        newLine.putAll(map2);
        result.add(sameLine);
        result.add(removedLine);
        result.add(newLine);
        return result;
    }
}
