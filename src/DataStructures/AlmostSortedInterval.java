package DataStructures;
//WA
import java.io.*;
import java.util.*;
import java.math.*;

public class AlmostSortedInterval {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            int ar[] = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
            }
            long ans = (long)n;
            for (int i = 0; i < n; i++) {
                int j = i;
                for (; j + 1 < n; j++) {
                    if(ar[j] > ar[j + 1]){
                        break;
                    }
                }
                int ne = (j - i);
                long lans = (ne * (ne + 1)) / 2;
                ans += lans;
                i = j;
            }
            out.write(Long.toString(ans));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

