package Contests.WorldCodeSprint11;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 27/05/17
 **/
public class SimpleFileCommand {
    public static Map<String, Queue<Integer>> deleted = new HashMap<>();
    public static Map<String, Integer> count = new HashMap<>();
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int q = in.readInt();
            for (int i = 0; i < q; i++) {
                String ops[] = in.readLine().split(" ");
                if (ops[0].equals("crt")) {
                    String name = ops[1];
                    out.write("+ "+create(name));
                }
                else if (ops[0].equals("del")) {
                    out.write("- "+delete(ops[1]));
                }
                else {
                    out.write(rename(ops[1], ops[2]));
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String create(String name) {
        if (deleted.containsKey(name)) {
            if (deleted.get(name).size() > 0) {
                int id = deleted.get(name).poll();
                if (id == 0) {
                    return name;
                }
                return name+ "(" + id + ")";
            }
            else {
                if (count.containsKey(name)){
                    int id = count.get(name);
                    count.put(name, id + 1);
                    return name + "(" + (id) + ")";
                }
                count.put(name, 1);
                return name;
            }
        }
        else {
            if (count.containsKey(name)){
                int id = count.get(name);
                count.put(name, id + 1);
                return name + "(" + (id) + ")";
            }
            count.put(name, 1);
            return name;
        }
    }
    private static String delete(String name) {
        if (name.contains("(")) {
            int index = name.indexOf("(");
            String checkName = name.substring(0, index);
            int counter = Integer.parseInt(name.substring(index+1, name.indexOf(")")));
            if (deleted.containsKey(checkName)) {
                deleted.get(checkName).add(counter);
            }
            else {
                Queue<Integer> pq = new PriorityQueue<>();
                pq.add(counter);
                deleted.put(checkName, pq);
            }
        }
        else {
            if (deleted.containsKey(name)) {
                deleted.get(name).add(0);
            }
            else {
                Queue<Integer> pq = new PriorityQueue<>();
                pq.add(0);
                deleted.put(name, pq);
            }
        }
        return name;
    }
    private static String rename(String from, String to) {
        delete(from);
        return "r "+from + " -> " + create(to);
    }
}
