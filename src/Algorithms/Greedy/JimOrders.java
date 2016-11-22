package Algorithms.Greedy;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class JimOrders {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            Queue<Job> pq = new PriorityQueue<Job>(1000000, new Job());
            for (int i = 0; i < n; i++) {
                pq.add(new Job(i + 1, in.readInt(), in.readInt()));
            }
            while(!pq.isEmpty()) {
                System.out.print(pq.poll().ind + " ");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Job implements Comparator<Job> {
    int ind, t, d;
    public Job(){

    }
    public Job(int i, int t, int d){
        this.ind = i;
        this.t = t;
        this.d = d;
    }
    @Override
    public int compare(Job j, Job b) {
        int ttj = j.t + j.d;
        int ttb = b.t + b.d;
        if (ttj < ttb) {
            return -1;
        }
        else if(ttj > ttb) {
            return 1;
        }
        else {
            return j.ind - b.ind;
        }
    }
}
