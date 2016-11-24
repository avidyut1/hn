package Algorithms.Strings;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class AlternatingCharacters {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                char car [] = in.readLine().toCharArray();
                int ans = 0;
                for (int i = 0; i < car.length; i++) {
                    int j = i;
                    while (j + 1 < car.length && car[j] == car[j + 1]) {
                        j++;
                    }
                    ans += (j - i);
                    i = j;
                }
                System.out.println(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
