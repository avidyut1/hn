package Contests.Hour14;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class BeautifulDayMovies {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int i = in.readInt();
            int j = in.readInt();
            int k = in.readInt();
            int ans = 0;
            for (int x = i; x <= j; x++) {
                int revx = reverse(x);
                if(Math.abs(revx - x) % k == 0){
                    ans++;
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int reverse(int x){
        int rev = 0;
        while(x > 0) {
            rev = rev * 10 + (x % 10);
            x = x / 10;
        }
        return rev;
    }
}
