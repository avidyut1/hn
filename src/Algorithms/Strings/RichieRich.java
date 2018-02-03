package Algorithms.Strings;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class RichieRich {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int k = in.readInt();
            char ar[] = in.readLine().toCharArray();
            int ari[] = new int[n];
            for (int i = 0; i < n; i++) {
                ari[i] = Integer.parseInt(Character.toString(ar[i]));
            }
            int j = n - 1;
            for (int i = 0; i < n; i++) {
                if (ari[i] != ari[j]) {
                    k--;
                    ari[i] = Math.max(ari[i], ari[j]);
                    ari[j] = ari[i];
                }
                j--;
                if (j < i) {
                    break;
                }
            }
            if (k >= 0) {
                j = n - 1;
                for (int i = 0; i < n; i++) {
                    if (ar[i] != ar[j]) {
                        ari[i] = 9;
                        ari[j] = 9;
                        k--;
                        if (k == 0) {
                            break;
                        }
                    }
                    else {
                        if (ari[i] == 9) {
                            j--;
                            continue;
                        }
                        if (k >= 2) {
                            ari[i] = 9;
                            ari[j] = 9;
                            k -= 2;
                        }
                        else if(i == j && k >= 1) {
                            ari[i] = 9;
                            k--;
                        }
                        if (k == 0) {
                            break;
                        }
                    }
                    j--;
                    if (j < i) {
                        break;
                    }
                }
                for (int i = 0; i < n; i++) {
                    out.write(Integer.toString(ari[i]));
                }
                out.newLine();
            }
            else if (k < 0) {
                out.write(Integer.toString(-1));;
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
