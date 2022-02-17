package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xierz
 * @date 2022/2/17
 */
public class Q49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>(strs.length);
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);
            result.computeIfAbsent(tempStr, key -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(result.values());
    }
}
