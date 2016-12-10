package AritificialIntelligence.BotBuilding;

import java.io.*;
import java.util.*;
import java.math.*;

public class BotClean {
    static void next_move(int posr, int posc, String[] board){
        //add logic here
        char grid[][] = new char[board.length][board.length];
        for (int i = 0; i < grid.length; i++) {
            grid[i] = board[i].toCharArray();
        }
        if (grid[posr][posc] == 'd') {
            System.out.println("CLEAN");
            grid[posc][posc] = '.';
        }
        while(gridHasDirty(grid)){
            int rc[] = nextDirtyCell(grid);
            while (rc[0] > posr) {
                posr++;
                System.out.println("DOWN");
            }
            while (rc[0] < posr) {
                posr--;
                System.out.println("UP");
            }
            while (rc[1] > posc) {
                posc++;
                System.out.println("RIGHT");
            }
            while (rc[1] < posc) {
                posc--;
                System.out.println("LEFT");
            }
            System.out.println("CLEAN");
            grid[posr][posc] = '.';
        }
    }
    public static int[] nextDirtyCell(char g[][]) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (g[i][j] == 'd')
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }
    public static boolean gridHasDirty(char g[][]) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if (g[i][j] == 'd')
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        String board[] = new String[5];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<5;i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}
