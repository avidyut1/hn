package HackerRankSeniorSoftwareEng;

import java.io.*;
import java.util.*;
import java.math.*;

public class Tickets {
    static long waitingTime(int[] tickets, int p) {
        IndexVal ar[] = new IndexVal[tickets.length];
        for (int i = 0; i < tickets.length; i++) {
            ar[i] = new IndexVal(i, tickets[i]);
        }
        Arrays.sort(ar);
        long ans = 0L;
        long waitTime = ar[0].id + ((ar[0].val - 1) * (ar.length));
        if (p == ar[0].id) {
            ans = waitTime + 1;
        }
        for (int i = 1; i < ar.length; i++) {
            long wt1 = ar[i - 1].val * ar.length;
            long wt2 = (ar[i].val - 1 - ar[i - 1].val) * (ar.length - i);
            waitTime = wt1 + wt2 + ar[i].id;
            if (ar[i].id == p) {
                ans = waitTime;
                break;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = null;
        if (fileName != null) {
            bw = new BufferedWriter(new FileWriter(fileName));
        }
        else {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        long res;
        int tickets_size = 0;
        tickets_size = Integer.parseInt(in.nextLine().trim());

        int[] tickets = new int[tickets_size];
        for(int i = 0; i < tickets_size; i++) {
            int tickets_item;
            tickets_item = Integer.parseInt(in.nextLine().trim());
            tickets[i] = tickets_item;
        }

        int p;
        p = Integer.parseInt(in.nextLine().trim());

        res = waitingTime(tickets, p);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }

    private static class IndexVal implements Comparable<IndexVal>{
        int id, val;

        public IndexVal(int id, int val) {
            this.id = id;
            this.val = val;
        }

        @Override
        public int compareTo(IndexVal o1) {
            return Integer.compare(this.val, o1.val);
        }
    }
}
