package MYTOOLS.practice;

import java.util.HashMap;
import java.util.Map;

public class JsonToObject {

    static String[] jsonStringInput = new String[3];

    static {
        jsonStringInput[0] = "{1:\'axuav\'},{2:\'iopz\'}";
        jsonStringInput[1] = "[{1:\'axuav\'},{2:\'iopz\'}]";
    }

    public static void main(String[] args) {
        //basic JSON to map
        String jsonString1 = jsonStringInput[0];
        Map<String, Object> map1 = new HashMap();
        String[] pairs1 = jsonString1.split(",");

        for (int i = 0; i < pairs1.length; i++) {
            String pair = pairs1[i].substring(1, pairs1[i].length() - 1);
            String[] st = pair.split(":");
            String key = st[0];
            Object value = st[1];
            map1.put(key, value);
        }
        System.out.println("basic json to map >>> " + map1);

        //1d array JSON to map
        String jsonString2 = jsonStringInput[1];
        Map<String, Object> map2 = new HashMap();
        jsonString2 = jsonString2.substring(1, jsonString2.length() - 1);
        String[] pairs2 = jsonString2.split(",");

        for (int i = 0; i < pairs2.length; i++) {
            String pair = pairs2[i].substring(1, pairs2[i].length() - 1);
            String[] st = pair.split(":");
            String key = st[0];
            Object value = st[1];
            map2.put(key, value);
        }
        System.out.println("1d Array json to map >>> " + map2);

    }


}
