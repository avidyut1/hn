package Contests.WorldCodeSprint12;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class RedKnightShortestPath {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            String[] order = new String[]{"UL", "UR", "R", "LR", "LL", "L"};
            int sx = in.readInt();
            int sy = in.readInt();
            int temp = sx;
            sx = sy;
            sy = temp;
            int ex = in.readInt();
            int ey = in.readInt();
            temp = ex;
            ex = ey;
            ey = temp;
            Queue<Cell> q = new LinkedList<>();
            q.add(new Cell(sx, sy, ""));
            Vector<String> answers = new Vector<>();
            boolean vis[][] = new boolean[n][n];
            while(!q.isEmpty()) {
                Cell c = q.poll();
//                System.out.println(c);
                if (c.x == ex && c.y == ey) {
                    answers.add(c.res);
                    break;
                }
                if (vis[c.x][c.y]) {
                    continue;
                }
                vis[c.x][c.y] = true;
                if (c.x - 1 >= 0 && c.y - 2 >= 0) {
                    q.add(new Cell(c.x - 1, c.y - 2, c.res + " UL"));
                }
                if (c.x + 1 < n && c.y - 2 >= 0) {
                    q.add(new Cell(c.x + 1, c.y - 2, c.res + " UR"));
                }
                if (c.x - 1 >= 0 && c.y + 2 < n) {
                    q.add(new Cell(c.x - 1, c.y + 2, c.res + " LL"));
                }
                if (c.x + 1 < n && c.y + 2 < n) {
                    q.add(new Cell(c.x + 1, c.y + 2, c.res + " LR"));
                }
                if (c.x + 2 < n) {
                    q.add(new Cell(c.x + 2, c.y, c.res + " R"));
                }
                if (c.x - 2 >= 0) {
                    q.add(new Cell(c.x - 2, c.y, c.res + " L"));
                }
            }
            Collections.sort(answers, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() > o2.length()) {
                        return 1;
                    }
                    else if (o1.length() == o2.length()) {
                        String first[] = o1.split(" ");
                        String second[] = o2.split(" ");
                        for (int i = 0; i < first.length; i++) {
                            int indexF = -1;
                            int indexS = -1;
                            for (int j = 0; j < order.length; j++) {
                                if (first[i].equals(order[j])) {
                                    indexF = j;
                                }
                                if (second[i].equals(order[j])) {
                                    indexS = j;
                                }
                            }
                            if (indexF < indexS) {
                                return -1;
                            }
                            else if (indexF > indexS) {
                                return 1;
                            }
                        }
                    }
                    return -1;
                }
            });
            if (answers.size() >= 1) {
                String resans[] = answers.get(0).split(" ");
                Vector<String> res = new Vector<String>();
                for (String s: resans) {
                    if (s.equals(""))
                        continue;
                    res.add(s);
                }
                Collections.sort(res, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int indexF = -1;
                        int indexS = -1;
                        for (int j = 0; j < order.length; j++) {
                            if (o1.trim().equals(order[j])) {
                                indexF = j;
                            }
                            if (o2.trim().equals(order[j])) {
                                indexS = j;
                            }
                        }
                        if (indexF < indexS) {
                            return -1;
                        }
                        else if (indexF > indexS) {
                            return 1;
                        }
                        return 0;
                    }
                });
                out.write(Integer.toString(res.size()));
                out.newLine();
                for (String sortedRes: res) {
                    out.write(sortedRes.trim() + " ");
                }
                out.newLine();
            }
            else {
                out.write("Impossible");
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Cell {
        int x, y;
        String res;

        public Cell(int x, int y, String res) {
            this.x = x;
            this.y = y;
            this.res = res;
        }

        @Override
        public String toString() {
            return this.x + " "+this.y + " "+this.res;
        }
    }
}
