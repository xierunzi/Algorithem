package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xierz
 * @date 2022/3/6
 */
public class Q30 {
    public static void main(String[] args) {
        System.out.println(new Q30().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
                new String[]{"fooo", "barr", "wing", "ding", "wing"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, AtomicInteger> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (i > 0 && words[i].length() != words[i - 1].length()) {
                return Collections.emptyList();
            }
            wordMap.computeIfAbsent(words[i], key -> new AtomicInteger()).incrementAndGet();
        }
        int len = words[0].length();
        int totalLen = len * words.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - totalLen; i++) {
            if (isTarget(s.substring(i, i + totalLen), wordMap, len)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isTarget(String param, Map<String, AtomicInteger> words, int len) {
        Map<String, AtomicInteger> existedMap = new HashMap<>(words.size());
        for (int i = 0; i <= param.length() - len; i += len) {
            String key = param.substring(i, i + len);
            if (words.containsKey(key)) {
                int times = existedMap.computeIfAbsent(key, str -> new AtomicInteger()).incrementAndGet();
                if (times > words.get(key).get()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (existedMap.size() != words.size()) {
            return false;
        }
        for (Map.Entry<String, AtomicInteger> entry : existedMap.entrySet()) {
            if (entry.getValue().intValue() != words.get(entry.getKey()).intValue()) {
                return false;
            }
        }
        return true;
    }
}
