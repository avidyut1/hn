package HackerRankHiring;

import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class WinningLotteryTicket {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = in.readInt();
            HashSet<Integer> maskSubMask[] = new HashSet[1 << 10];
            int masks[] = new int[n];
            BitSet count[] = new BitSet[1 << 10];
            for (int i = 0; i < count.length; i++) {
                count[i] = new BitSet(1000000);
                maskSubMask[i] = new HashSet<>();
            }
            for (int i = 0; i < n; i++) {
                int mask = 0;
                String num = in.readLine().trim();
                char inp[] = num.toCharArray();
                for (int j = 0; j < inp.length; j++) {
                    mask |= 1 << (inp[j] - '0');
                }
                masks[i] = mask;
                count[mask].set(i);
            }
            int allSet = 0;
            for (int i = 0; i < 10; i++) {
                allSet |= 1 << i;
            }
            long st = System.currentTimeMillis();
            for (int mask = 0; mask < count.length; mask++) {
                for (int j = 0; j < count.length; j++) {
                    int msk = mask;
                    for (int bit = 0; bit < 10; bit++) {
                        if ((j & (1 << bit)) != 0 && (msk ^ (1 << bit)) != 0) {
                            msk &= ~(1 << bit);
                        }
                    }
                    maskSubMask[mask].add(msk);
                    maskSubMask[mask].add(mask);
                }
            }
//            System.out.println("masks");
//            for (int i = 0; i < n; i++) {
//                System.out.println(i +" = "+masks[i]+ " "+maskSubMask[masks[i]]);
//            }
            HashSet<Integer> allMasks = new HashSet<>();
            for (int i = 0; i < masks.length; i++) {
                allMasks.add(masks[i]);
            }
            HashSet<Integer> maskCounterPart[] = new HashSet[1 << 10];
            for (int i = 0; i < 1 << 10; i++) {
                maskCounterPart[i] = new HashSet<>();
            }
            for (int i = 0; i < 1 << 10; i++) {
                for (int j = i; j < 1 << 10; j++) {
                    if ((i | j) == allSet) {
                        maskCounterPart[i].add(j);
                        maskCounterPart[j].add(i);
                    }
                }
            }
            long et = System.currentTimeMillis();
//            System.out.println(et - st);
//            for (int i = 0; i < count.length; i++) {
//                if (count[i].size() > 0) {
//                    System.out.println(i+" "+count[i]);
//                }
//            }
            st = System.currentTimeMillis();
            long ans = 0L;
            for(int mask: allMasks) {
//                System.out.println(mask);
                int numsForMask = count[mask].cardinality();
                BitSet counter = new BitSet(1000000);
                for (int mskSub: maskSubMask[mask]) {
                    for(int counterPart: maskCounterPart[mskSub]) {
                        counter.or(count[counterPart]);
                    }
                }
                int number = 0;
                for (int i = count[mask].nextSetBit(0); i != -1; i = count[mask].nextSetBit(i + 1)) {
                    if (counter.get(i)) {
                        counter.set(i, false);
                        number++;
                    }
                }
                ans += (((long)number * (number - 1))) + (numsForMask * counter.cardinality());
            }
            et = System.currentTimeMillis();
//            System.out.println(et - st);
            out.write(Long.toString(ans / 2));
            out.newLine();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

