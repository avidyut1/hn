package Contests.Codeagon17;

import java.io.*;
import java.util.*;
import java.math.*;

public class DependencyHell {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int q = in.readInt();
            for (int qc = 0; qc < q; qc++) {
                int n = in.readInt();
                int m = in.readInt();
                Vector<Integer> dep[] = new Vector[n];
                for (int i = 0; i < n; i++) {
                    dep[i] = new Vector<>();
                }
                for (int i = 0; i < n; i++) {
                    int num = in.readInt();
                    for (int j = 0; j < num; j++) {
                        dep[i].add(in.readInt() - 1);
                    }
                    Collections.sort(dep[i], Collections.reverseOrder());
                }
                Vector<Integer> ans = new Vector<>();
                Vector<Integer> prog = new Vector<>();
                for (int i = 0; i < m; i++) {
                    int p = in.readInt() - 1;
                    prog.add(p);
                }
                Collections.sort(prog);
                for (int p : prog) {
                    if (!ans.contains(p)) {
                        ans.add(p);
                        go(p, ans, dep);
                    }
                }
                Collections.reverse(ans);
                out.write(Integer.toString(ans.size()));
                out.newLine();
                int resar[] = new int[ans.size()];
                for (int i = 0; i < ans.size(); i++) {
                    resar[i] = ans.get(i);
                }
                Vector<Integer> alldep[] = new Vector[n];
                for (int i = 0; i < n; i++) {
                    alldep[i] = new Vector<>();
                    populate(alldep, dep, i, i);
                }
                for (int i = 0; i < ans.size() - 1; i++) {
                    for (int j = 0; j < ans.size() - i - 1; j++) {
                        if (resar[j] > resar[j + 1]) {
                            if (!alldep[resar[j + 1]].contains(resar[j])) {
                                int temp = resar[j];
                                resar[j] = resar[j + 1];
                                resar[j + 1] = temp;
                            }
                        }
                    }
                }
                for (int i = 0; i < ans.size(); i++) {
                    out.write(Integer.toString(resar[i] + 1)+" ");
                }
                out.newLine();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void populate(Vector<Integer> ad[], Vector<Integer> d[], int i, int dep) {
        for (int dpd: d[dep]) {
            ad[i].add(dpd);
            populate(ad, d, i, dpd);
        }
    }
    public static void go(int p, Vector<Integer> ans, Vector<Integer> d[]) {
        if (d[p].size() == 0) {
            return;
        }
        for (int dep: d[p]) {
            if (ans.contains(dep)) {
                int ind = ans.indexOf(dep);
                int indp = ans.indexOf(p);
                if (ind < indp) {
                    ans.remove(ind);
                    ans.add(indp, dep);
                }
                continue;
            }
            ans.add(dep);
            go(dep, ans, d);
        }
    }
}
