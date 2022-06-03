import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MapUtil {
    public static void printMap(Map<Integer, Integer> map) {
        for(Integer k : map.keySet()){
            System.out.println(k + " -- " + map.get(k));
        }
    }

    public static void printMapWithList(Map<Integer, List<Integer>> map) {
        for(Integer k : map.keySet()){
            System.out.println(k + " -- " + Arrays.toString(map.get(k).toArray()));
        }
    }
}
