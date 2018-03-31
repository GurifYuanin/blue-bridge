package training;

import java.util.Scanner;  

public class ALGO_116_2 {  
    public static int N, K;  
    public static int [] array;  
    public static int []  sum;  
  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        Scanner scan = new Scanner(System.in);  
        N = scan.nextInt();  
        K = scan.nextInt();  
        array = new int[N+1];  
        sum = new int[N+1];  
        for(int i = 1; i <= N; i++){  
            array[i] = scan.nextInt();  
            sum[i] = sum[i-1] + array[i];  
        }  
        int[][] end = new int[N+1][K+1];  
  
        String [][] sign = new String[N+1][K+1];  
        for(int i = 1; i <= N; i++){  
            end[i][0] = sum[i];  
        }  
        for(int i = 1; i <= N; i++)  
            for(int j = 1; j <= K; j++){  
                if(i-1 >= j)  
                for(int k = 1; k < i; k++){  
                    if(end[i][j]<end[k][j-1]*(sum[i]-sum[k])){  
                        end[i][j]=end[k][j-1]*(sum[i]-sum[k]);  
                        sign[i][j] = k+"-"+(j-1);  
                    };  
                }  
            }  
        /*for(int i = 0; i <= N; i++){ 
            for(int j = 0; j <= K; j++) 
                System.out.print(end[i][j]+" "); 
            System.out.println(); 
        } 
        System.out.println("-----------------"); 
        for(int i = 0; i <= N; i++){ 
            for(int j = 0; j <= K; j++) 
                System.out.print(sign[i][j]+" "); 
            System.out.println(); 
        }*/  
        System.out.println(end[N][K]);  
    }  
  
}  