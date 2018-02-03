package HackerRankTechnicalContent;

import java.io.*;
import java.util.*;
import java.math.*;

public class ArrayReduction {
    static int reductionCost(int[] num) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < num.length; i++) {
            pq.add(num[i]);
        }
        int ans = 0;
        while(pq.size() >= 2) {
            int f = pq.poll();
            int s = pq.poll();
            pq.add(f + s);
            ans += f + s;
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

        int res;
        int num_size = 0;
        num_size = Integer.parseInt(in.nextLine().trim());

        int[] num = new int[num_size];
        for(int i = 0; i < num_size; i++) {
            int num_item;
            num_item = Integer.parseInt(in.nextLine().trim());
            num[i] = num_item;
        }

        res = reductionCost(num);
        bw.write(String.valueOf(res));
        bw.newLine();

        bw.close();
    }
}
