package training;

import java.util.Scanner;  

class ALGO_3{  
    static int MOD=1000000007 ;  
      
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        int k = sc.nextInt();  
        int l = sc.nextInt();  
        int dp[][] = new int[101][101];  
        for (int i = 0; i < k; i++) {  
            dp[1][i] = 1;  
        }  
        for (int i = 2; i <=l; i++) {  
            for (int j = 0; j < k; j++) {  
                for (int j2 = 0; j2 < k; j2++) {  
                    if(j2 != j-1 && j2 != j+1){  
                        dp[i][j] += dp[i-1][j2];  
                        dp[i][j] %= MOD;   
                    }  
                }  
            }  
        }  
        int sum = 0;  
        for (int i = 1; i < k; i++) {  
            sum+= dp[l][i];  
            sum %= MOD;  
        }  
        System.out.println(sum);  
          
    }  
}  