package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class SuperReducedStrings {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            String s = in.readLine();
            Vector<Character> vs = new Vector<Character>();
            for (int i = 0; i < s.length(); i++) {
                vs.add(s.charAt(i));
            }
            while(true) {
                Set<Integer> removeind = new HashSet<Integer>();
                for (int i = 0; i < vs.size() - 1; i++) {
                    if (vs.get(i) == vs.get(i + 1)) {
                        removeind.add(i);
                        removeind.add(i + 1);
                        i++;
                    }
                }
                if (removeind.size() == 0) {
                    break;
                }
                Vector<Character> nvs = new Vector<Character>();
                for (int i = 0; i < vs.size(); i++) {
                    if (removeind.contains(i))
                        continue;
                    nvs.add(vs.get(i));
                }
                vs = nvs;
            }
            for (int i = 0; i < vs.size(); i++) {
                System.out.print(vs.get(i));
            }
            if(vs.isEmpty()) {
                System.out.println("Empty String");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
