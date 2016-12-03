package Contests.Week26;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class BestDivisor {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int maxsum = 0;
            int number = -1;
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    int sum = sod(i);
                    if (maxsum < sum) {
                        maxsum = sum;
                        number = i;
                    }
                    else if(maxsum == sum) {
                        if (number > i) {
                            number = i;
                        }
                    }
                    sum = sod(n / i);
                    if (maxsum < sum) {
                        maxsum = sum;
                        number = n/i;
                    }
                    else if(maxsum == sum) {
                        if (number > n / i) {
                            number = n / i;
                        }
                    }
                }
            }
            System.out.println(number);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int sod(int i) {
        int sum = 0;
        while(i > 0) {
            sum += (i % 10);
            i = i / 10;
        }
        return sum;
    }
}
