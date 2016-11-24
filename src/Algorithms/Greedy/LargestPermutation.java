package Algorithms.Greedy;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class LargestPermutation {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            int k = in.readInt();
            int ar[] = new int[n];
            Queue<IV> q = new PriorityQueue<IV>(10000000, new IV());
            for (int i = 0; i < n; i++) {
                ar[i] = in.readInt();
                q.add(new IV(i, ar[i]));
            }
            int ind = 0;
            while(k > 0 && !q.isEmpty()) {
                IV r = q.poll();
                if (ar[r.i] != r.v) {
                    continue;
                }
                if (r.v > ar[ind]) {
                    int temp = ar[ind];
                    ar[ind] = r.v;
                    ar[r.i] = temp;
                    q.add(new IV(r.i, temp));
                    k--;
                    ind++;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(ar[i]+ " ");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class IV implements Comparator<IV>{
    int i, v;
    public IV(){

    }
    public IV(int ind, int val){
        this.i = ind;
        this.v = val;
    }
    @Override
    public int compare(IV f, IV s) {
        if (f.v > s.v) {
            return -1;
        }
        else if(s.v > f.v) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
