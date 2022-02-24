package demo.algorithem.leetcode.practice;

import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xierz
 * @date 2022/2/24
 */
public class Q71 {
    public static void main(String[] args) {
        System.out.println(new Q71().simplifyPath("/..hidden"));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        char[] pathChars = path.toCharArray();
        AtomicInteger index = new AtomicInteger();
        while (index.get() < path.length()) {
            String next = next(pathChars, index);
            if (Objects.equals(next, "") || (!stack.isEmpty() && Objects.equals("/", next) && Objects.equals("/", stack.peek()))) {
            } else if (next == null) {
                if (stack.size() > 2) {
                    stack.pop();
                    stack.pop();
                }
            } else {
                stack.push(next);
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            String temp = stack.pop();
            if (builder.length() == 0 && Objects.equals("/", temp) && !stack.isEmpty()) {
                continue;
            }
            builder.insert(0, temp);
        }
        return builder.toString();
    }

    private String next(char[] path, AtomicInteger index) {
        int indexValue = index.get();
        if (indexValue >= path.length) {
            return "";
        }
        if (path[indexValue] == '/') {
            int temp = indexValue + 1;
            while (temp < path.length && path[temp] == '/') {
                temp++;
            }
            index.set(temp);
            return "/";
        } else if (path[indexValue] == '.') {
            int count = 1;
            int temp = indexValue + 1;
            StringBuilder builder = new StringBuilder(".");
            boolean flag = true;
            while (temp < path.length && path[temp] != '/') {
                if (path[temp] != '.') {
                    flag = false;
                }
                count++;
                builder.append(path[temp]);
                temp++;
            }
            index.set(temp);
            if (count == 1) {
                return "";
            } else if (count == 2 && flag) {
                return null;
            } else {
                return builder.toString();
            }
        } else {
            int temp = indexValue + 1;
            while (temp < path.length && path[temp] != '/') {
                temp++;
            }
            index.set(temp);
            int len = temp - indexValue;
            char[] res = new char[len];
            System.arraycopy(path, indexValue, res, 0, len);
            return new String(res);
        }
    }
}
