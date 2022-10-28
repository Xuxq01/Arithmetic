import java.util.Scanner;

/**
 * @PROJECT_NAME: basic-code
 * @DESCRIPTION: Warshall算法求解矩阵传递闭包
 * @USER: 11240
 * @DATE: 2022/10/28 21:54
 */
public class WarshallArithmetic {
    public static void main(String[] args) {
        int[][] arr = getArr();
        Warshall(arr,arr.length);
    }

    public static int[][] getArr(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入矩阵的阶数");
        int n = sc.nextInt();
        System.out.println("请输入矩阵的值:");
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }

    private static void Warshall(int[][] arr, int n) {
        int j = 0;
        for (int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++){
                if(arr[i][j] == 1){
                    for (int a = 0; a < n; a++) {
                        arr[i][a] = arr[j][a] + arr[i][a];
                        if(arr[i][a] > 1){
                            arr[i][a] = 1;
                        }
                    }
                }
            }
            j++;
        }
        for(int i = 0; i < n; i++){
            for (int t = 0; t < n; t++) {
                System.out.print(arr[i][t] + " ");
            }
            System.out.println();
        }
    }
}
