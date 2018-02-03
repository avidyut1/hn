package HackerRankHiring;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class ProgrammingCompetition {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            Candidate car[] = new Candidate[n];
            for (int i = 0; i < n; i++) {
                String data[] = in.readLine().split(" ");
                car[i] = new Candidate(i, data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            }
            Arrays.sort(car);
            out.write(car[0].name + " " + Integer.toString(car[0].j - car[0].d));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Candidate implements Comparable<Candidate> {
        int id;
        String name;
        int d, j;
        public Candidate(int id, String n, int d, int j) {
            this.name = n;
            this.id = id;
            this.d = d;
            this.j = j;
        }

        @Override
        public int compareTo(Candidate o) {
            int diffthis = j - d;
            int diffthat = o.j - o.d;
            if (diffthat == diffthis) {
                return Integer.compare(this.id, o.id);
            }
            return Integer.compare(diffthat, diffthis);
        }
    }
}
