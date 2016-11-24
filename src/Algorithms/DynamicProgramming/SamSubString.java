package Algorithms.DynamicProgramming;

import Contests.Codeagon.InputReader;
import sun.rmi.server.InactiveGroupException;

import java.io.*;
import java.util.*;
import java.math.*;

public class SamSubString {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            final int MOD = (int)1e9 + 7;
            char[] sar = in.readLine().toCharArray();
            int dp[] = new int[sar.length];
            dp[0] = Integer.parseInt(Character.toString(sar[0]));
            for (int i = 1; i < sar.length; i++) {
                dp[i] = ((i + 1) * Integer.parseInt(Character.toString(sar[i]))) + (10 * dp[i - 1]);
                dp[i] %= MOD;
            }
            int sum = 0;
            for (int i = 0; i < dp.length; i++) {
                sum += dp[i];
                sum %= MOD;
            }
            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
