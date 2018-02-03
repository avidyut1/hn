package Contests.Hack10144;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class AliceBob {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            final int MAX = (int)1e5 + 1;
            boolean isprime[] = new boolean[MAX];
            Arrays.fill(isprime, true);
            isprime[0] = false;
            isprime[1] = false;
            for (int i = 0; i < MAX; i++) {
                if (isprime[i]) {
                    for (int j = 2 * i; j < MAX; j+=i) {
                        isprime[j] = false;
                    }
                }
            }
            int numberprime[] = new int[MAX];
            for (int i = 0; i < MAX; i++) {
                if (isprime[i]) {
                    numberprime[i] = 1;
                }
                numberprime[i] += (i - 1 >= 0) ? numberprime[i - 1] : 0;
            }
            int g = in.readInt();
            for (int i = 0; i < g; i++) {
                int n = in.readInt();
                if (numberprime[n] % 2 == 0) {
                    System.out.println("Bob");
                }
                else{
                    System.out.println("Alice");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
