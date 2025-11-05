package hexlet.code;

import java.util.HashMap;
import java.util.Map;

public class FileComparator {
    public static Map<String, Object> compare(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, Object> resMap = new HashMap<>();
        map1.forEach((key, value) -> {
           if (map2.containsKey(key)) {
               if (value.equals(map2.get(key))) {
                   resMap.put(key, value);
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
        resMap.putAll(map2);
        return resMap;
    }
    // Тестовый кусок?
    public static String display(Map<String, Object> map) {
        String result = "{";
        for (var key : map.keySet()) {
            result += "\n" +key + ": " + map.get(key);
        }
        result += "\n}";
        return result;
    }
}
