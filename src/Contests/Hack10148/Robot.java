package Contests.Hack10148;

import java.io.*;
import java.util.*;
import java.math.*;

/**
 * created by asheshvidyut on 22/04/17
 **/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Robot {

    static int howManyCollisions(String s){
        // Complete this function
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'r' && s.charAt(i + 1) == 'l') {
                ans += 2;
            }
        }
        s = s.replace("rl", "d");
        char c[] = s.toCharArray();
        int countR[] = new int[c.length];
        int countL[] = new int[c.length];
        int n = c.length;
        for(int i = 0; i < n; i++){
            if (c[i] == 'r'){
                countR[i]++;
                countR[i] += i - 1 >= 0 && c[i - 1] != 'd' ? countR[i - 1] : 0;
            }
            else if(c[i] == 'd') {
                countR[i] = i - 1 >= 0 && c[i - 1] != 'd' ? countR[i - 1] : 0;
            }
        }
        for(int i = n - 1; i >= 0; i--){
            if (c[i] == 'l'){
                countL[i]++;
                countL[i] += i + 1 < n && c[i + 1] != 'd' ? countL[i + 1]: 0;
            }
            else if(c[i] == 'd') {
                countL[i] = i + 1 < n && c[i + 1] != 'd' ? countL[i + 1] : 0;
            }
        }
        for (int i = 0; i < n; i++){
            if (c[i] == 'd'){
                ans += countR[i] + countL[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            // Returns the number of times moving robots collide.
            int result = howManyCollisions(s);
            System.out.println(result);
        }
    }
}

