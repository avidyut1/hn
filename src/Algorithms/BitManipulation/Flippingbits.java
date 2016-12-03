package Algorithms.BitManipulation;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class Flippingbits {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int tc = in.readInt();
            for (int t = 0; t < tc; t++) {
                int n = in.readInt();
                String sn = Integer.toBinaryString(n);
                char car[] = new char[32];
                Arrays.fill(car, '0');
                int j = sn.length() - 1;
                for (int i = 31; i >= 0; i--) {
                    if (j < 0)
                        break;
                    car[i] = sn.charAt(j--);
                }
                //flip
                int ar[] = new int[32];
                for (int i = 0; i < 32; i++) {
                    ar[i] = 1 - Integer.parseInt(Character.toString(car[i]));
                }
                String res = "";
                for (int i = 0; i < ar.length; i++) {
                    res += ar[i];
                }
                System.out.println(Long.parseLong(res, 2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
