    package Contests.Hack10144;

    import Algorithms.InputReader;

    import java.io.*;
    import java.util.*;
    import java.math.*;

    public class ExpectedTreeLeaves {
        public static void main(String args[]) {
            try {
                final int MOD = (int)1e9 + 7;
                final int MAX = (int)1e5 + 1;
                int fact[] = new int[MAX];
                fact[0] = 1;
                for (int i = 1; i < MAX; i++) {
                    fact[i] = (fact[i - 1] % MOD * i % MOD) % MOD;
                }
                InputReader in = new InputReader(System.in);
                int n = in.readInt();
                long ans = binPow(2, MOD - 2, MOD);
                System.out.println(mulmod(mulmod(ans % MOD, n % MOD, MOD), fact[n], MOD));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public static long mulmod(long a, long b, long c){
            long x = 0, y = a % c;
            while(b > 0){
                if(b % 2 == 1){
                    x = (x + y) % c;
                }
                y = (y * 2) % c;
                b /= 2;
            }
            return x % c;
        }
        public static long binPow(long a , long b, int mod){
            long ans = 1l;
            long pow = a;
            while(b > 0){
                if((b % 2) == 1){
                    ans *= pow;
                    if(mod != -1)
                        ans %= mod;
                }
                pow *= pow;
                if(mod != -1)
                    pow %= mod;
                b /= 2;
            }
            return ans;
        }
    }
