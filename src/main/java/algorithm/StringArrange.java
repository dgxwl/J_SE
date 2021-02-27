package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 列出字符所有排列顺序
 */
public class StringArrange {
    public static void main(String[] args) {
        String s = "王刚看了直摇头";
        char[] charArray = s.toCharArray();
        int arrangeNum = stepMultiply(s.length());

        Random random = new Random();
        Set<List<Integer>> arrangeUsed = new HashSet<>(arrangeNum);
        List<String> result = new ArrayList<>(arrangeNum);
        while (true) {
            List<Integer> seq = new ArrayList<>(s.length());
            Set<Integer> used = new HashSet<>(s.length());
            while (true) {
                int index = random.nextInt(s.length());
                if (!used.add(index)) {
                    continue;
                }
                seq.add(index);
                if (seq.size() == s.length()) {
                    break;
                }
            }

            if (!arrangeUsed.add(seq)) {
                continue;
            }

            StringBuilder builder = new StringBuilder();
            for (Integer idx : seq) {
                builder.append(charArray[idx]);
            }

            result.add(builder.toString());

            if (arrangeUsed.size() == arrangeNum) {
                break;
            }
        }

        Collections.sort(result);
        for (String r : result) {
            System.out.println(r);
        }
    }

    public static int stepMultiply(int num) {
        if (num == 1) {
            return num;
        }
        return num * stepMultiply(num - 1);
    }
}
