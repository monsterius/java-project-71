package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;

public class FileComparator {
    public static List<String> compare(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Object> resMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        map1.forEach((key, value) -> {
           if (map2.containsKey(key)) {
               if (value.equals(map2.get(key))) {
                   resMap.put(" " + key, value);
                   map2.remove(key);
               } else {
                   resMap.put("-" + key, value);
                   resMap.put("+" + key, map2.get(key));
                   map2.remove(key);
               }
           } else  {
               resMap.put("-" + key, value);
           }
        });
        map2.forEach((key, value) -> resMap.put("+" + key, value));

        Comparator<String> comparator = (o1, o2) -> {
            String cleanO1 = o1.replaceAll("^[ +-]", "");
            String cleanO2 = o2.replaceAll("^[ +-]", "");
            return cleanO1.compareToIgnoreCase(cleanO2);
        };

        for (var key : resMap.keySet()) {
            result.add(key + ": " + resMap.get(key));
        }

        result.sort(comparator);
        return result;
    }

    public static String display(List<String> list) {
        String result = "{";
        for (var obj : list) {
            result += "\n  "  + obj;
        }
        return result += "\n}";
    }
}
