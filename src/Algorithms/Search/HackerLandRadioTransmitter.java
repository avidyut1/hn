package Algorithms.Search;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class HackerLandRadioTransmitter {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int k = in.readInt();
            final int MAX = (int)1e5 + 1;
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            Arrays.sort(ar);
            int first = ar[0] + k;
            int ans = 0;
            if (Arrays.binarySearch(ar, first) < 0) {
                int ind = Arrays.binarySearch(ar, first);
                ind = -1 - ind;
                ind--;
                first = ar[ind];
                ans = 1;
            }
            else {
                int ind = Arrays.binarySearch(ar, first);
                first = ar[ind];
                ans = 1;
            }
            int covered = first + k;
            int i = 1;
            while(i != n) {
                while(i < n && covered >= ar[i]) {
                    i++;
                }
                if (i == n) {
                    break;
                }
                first = ar[i] + k;
                if (Arrays.binarySearch(ar, first) < 0) {
                    int ind = Arrays.binarySearch(ar, first);
                    ind = -1 - ind;
                    ind--;
                    first = ar[ind];
                    ans++;
                    i = ind + 1;
                    covered = first + k;
                }
                else {
                    ans++;
                    int ind = Arrays.binarySearch(ar, first);
                    i = ind;
                    covered = first + k;
                }
            }
            System.out.println(ans);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
