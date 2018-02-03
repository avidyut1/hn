package HackerRankSeniorSoftwareEng;

import java.io.*;
import java.util.*;
import java.math.*;

public class PushPop {
    /*
    * Complete the function below.
    */
    static long[] maxMin(String[] operations, int[] x) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> priorityQueueReverse = new PriorityQueue<>(x.length, Collections.reverseOrder());
        long solutions[] = new long[operations.length];
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("push")) {
                priorityQueue.add(x[i]);
                priorityQueueReverse.add(x[i]);
            }
            else {
                priorityQueue.remove(x[i]);
                priorityQueueReverse.remove(x[i]);
            }
            long ans = priorityQueue.peek() * priorityQueueReverse.peek();
            solutions[i] = ans;
        }
        return solutions;
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

        long[] res;
        int operations_size = 0;
        operations_size = Integer.parseInt(in.nextLine().trim());

        String[] operations = new String[operations_size];
        for(int i = 0; i < operations_size; i++) {
            String operations_item;
            try {
                operations_item = in.nextLine();
            } catch (Exception e) {
                operations_item = null;
            }
            operations[i] = operations_item;
        }

        int x_size = 0;
        x_size = Integer.parseInt(in.nextLine().trim());

        int[] x = new int[x_size];
        for(int i = 0; i < x_size; i++) {
            int x_item;
            x_item = Integer.parseInt(in.nextLine().trim());
            x[i] = x_item;
        }

        res = maxMin(operations, x);
        for(int res_i = 0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }
}
