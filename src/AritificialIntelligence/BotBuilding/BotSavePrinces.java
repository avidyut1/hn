package AritificialIntelligence.BotBuilding;

import Contests.Codeagon.InputReader;

import java.io.*;
import java.util.*;
import java.math.*;

public class BotSavePrinces {
    public static void main(String args[]) {
        try {
            InputReader in = new InputReader(System.in);
            int n = in.readInt();
            char c[][] = new char[n][n];
            int rb = -1, cb = -1;
            int rp = -1, cp = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    c[i][j] = in.readCharacter();
                    if (c[i][j] == 'm') {
                        rb = i; cb = j;
                    }
                    if (c[i][j] == 'p') {
                        rp = i; cp = j;
                    }
                }
            }
            if (rb > rp) {
                for (int i = rb; i > rp; i--) {
                    System.out.println("UP");
                }
                if (cb < cp) {
                    for (int i = cb; i < cp; i++) {
                        System.out.println("RIGHT");
                    }
                }
                else {
                    for (int i = cb; i > cp; i--) {
                        System.out.println("LEFT");
                    }
                }
            }
            else {
                for (int i = rb; i < rp; i++) {
                    System.out.println("DOWN");
                }
                if (cb < cp) {
                    for (int i = cb; i < cp; i++) {
                        System.out.println("RIGHT");
                    }
                }
                else {
                    for (int i = cb; i > cp; i--) {
                        System.out.println("LEFT");
                    }
                }
                if (cb < cp) {
                    for (int i = cb; i <= cp; i++) {
                        System.out.println("RIGHT");
                    }
                }
                else {
                    for (int i = cp; i >= cb; i--) {
                        System.out.println("LEFT");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
