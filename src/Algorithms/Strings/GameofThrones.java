package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class GameofThrones {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            char car[] = (in.readLine()).toCharArray();
            int freq[] = new int[26];
            for (int i = 0; i < car.length; i++) {
                freq[car[i] - 'a']++;
            }
            int countodd = 0;
            for (int i = 0; i < 26; i++) {
                if (freq[i] % 2 != 0) {
                    countodd++;
                }
            }
            if (countodd == 1 || countodd == 0) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
