package Contests.WalmartCodesprint;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class HikingSelfies {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int x = in.readInt();
            int frames = (int)Math.pow(2, n) - 1;
            System.out.println(Math.abs(x - frames));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
