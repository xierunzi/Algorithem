package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xierz
 * @date 2022/1/23
 */
public class Q68 {
    public static void main(String[] args) {
        List<String> result = new Q68().fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20);
        System.out.println(result);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int len;
        for (int i = 0; i < words.length; i++) {
            len = words[i].length();
            int j;
            for (j = i + 1; j < words.length; j++) {
                len += words[j].length() + 1;
                if (len > maxWidth) {
                    len -= words[j].length() + 1;
                    j--;
                    break;
                } else if (len == maxWidth) {
                    break;
                }
            }
            result.add(getString(words, i, j, maxWidth, j >= words.length - 1));
            i = j;
        }
        return result;
    }

    private String getString(String[] words, int start, int end, int maxWidth, boolean lastRow) {
        if (end >= words.length) {
            end = words.length - 1;
        }
        String[] wordsCopy = Arrays.copyOfRange(words, start, end + 1);
        boolean singleWord = wordsCopy.length == 1;
        int totalLen = 0;
        for (String s : wordsCopy) {
            totalLen += s.length();
        }
        if (lastRow) {
            for (int i = 0; i < wordsCopy.length; i++) {
                if (i != wordsCopy.length - 1) {
                    wordsCopy[i] = wordsCopy[i] + " ";
                }
            }
        } else {
            int index = 0;
            while (totalLen < maxWidth) {
                wordsCopy[index] = wordsCopy[index] + " ";
                index++;
                totalLen++;
                if ((!singleWord && index == wordsCopy.length - 1) || index >= wordsCopy.length) {
                    index = 0;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (String s : wordsCopy) {
            builder.append(s);
        }
        while (builder.length() < maxWidth) {
            builder.append(" ");
        }
        return builder.toString();
    }

}
