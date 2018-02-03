import Algorithms.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class HackerRankOnsite {
    static class TransactionApi{
        Hashtable<String, String> keyValueStore;
        Hashtable<String, Integer> countValue;
        public TransactionApi() {
            this.keyValueStore = new Hashtable<>();
            this.countValue = new Hashtable<>();
        }
        public void dumpTransaction(Hashtable<String, String> txKeyValue, Hashtable<String, Integer> txCountValue) {
            for (String key: txKeyValue.keySet()) {
                this.keyValueStore.put(key, txKeyValue.get(key));
            }
            for (String value: txCountValue.keySet()) {
                this.countValue.put(value, this.countValue.containsKey(value) ? this.countValue.get(value) + txCountValue.get(value): txCountValue.get(value));
            }
        }
        public int getCount(String key){
            if (countValue.contains(key)) {
                return countValue.get(key);
            }
            return 0;
        }
        public String get(String key){
            if (keyValueStore.containsKey(key)) {
                return keyValueStore.get(key);
            }
            return "NULL";
        }
    }
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            TransactionApi transactionApi = new TransactionApi();
            Hashtable<String, String> txKV = new Hashtable<>();
            Hashtable<String, Integer> txCount = new Hashtable<>();
            while(true) {
                txKV.clear();
                txCount.clear();
                String command = in.readLine();
                if (command.equals("Begin")) {
                    while(!command.equals("Commit") || !command.equals("Rollback")) {
                        try {
                            if (command.charAt(0) == 'S') {
                                String inp[] = command.split(" ");
                                txCount.put(inp[2], txCount.containsKey(inp[2]) ? txCount.get(inp[2]) - 1 : -1);
                                txKV.put(inp[1], inp[2]);
                            }
                            else if (command.charAt(0) == 'G') {
                                String inp[] = command.split(" ");
                                if (txKV.containsKey(inp[1])) {
                                    System.out.println(txKV.get(inp[1]));
                                }
                                else {
                                    System.out.println(transactionApi.get(inp[1]));
                                }
                            }
                            else if (command.charAt(0) == 'C') {
                                String inp[] = command.split(" ");
                                System.out.println(txCount.get(inp[1]) + transactionApi.getCount(inp[2]));
                            } else {
                                String inp[] = command.split(" ");
                                txKV.put(inp[1], "0");
                                txCount.put(inp[2], txCount.containsKey(inp[2]) ? txCount.get(inp[2]) - 1 : -1);
                            }
                        }
                        catch (NullPointerException e) {
                            System.out.println("NULL");
                        }
                    }
                    if (command.equals("Rollback")) {
                        continue;
                    }
                    transactionApi.dumpTransaction(txKV, txCount);
                }
                else {
                    try {
                        if (command.charAt(0) == 'S') {
                            String inp[] = command.split(" ");
                            txCount.put(inp[2], txCount.containsKey(inp[2]) ? txCount.get(inp[2]) - 1 : -1);
                            txKV.put(inp[1], inp[2]);
                        }
                        else if (command.charAt(0) == 'G') {
                            String inp[] = command.split(" ");
                            if (txKV.containsKey(inp[1])) {
                                System.out.println(txKV.get(inp[1]));
                            }
                            else {
                                System.out.println(transactionApi.get(inp[1]));
                            }
                        }
                        else if (command.charAt(0) == 'C') {
                            String inp[] = command.split(" ");
                            System.out.println(txCount.get(inp[1]) + transactionApi.getCount(inp[2]));
                        } else {
                            String inp[] = command.split(" ");
                            txKV.put(inp[1], "0");
                            txCount.put(inp[2], txCount.containsKey(inp[2]) ? txCount.get(inp[2]) - 1 : -1);
                        }
                    }
                    catch(NullPointerException e){
                        System.out.println("NULL");
                    }
                    transactionApi.dumpTransaction(txKV, txCount);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
