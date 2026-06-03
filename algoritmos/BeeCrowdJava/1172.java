import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numeros = new int[10];

        for(int i = 0; i< 10;i++){
            int n = sc.nextInt();
            if(n < 1){
                n = 1;
                numeros[i] = n;
            }else{
                numeros[i] = n;
            }
        }

        for(int i = 0; i<10; i++){
            System.out.printf("X[%d] = %d\n", i, numeros[i]);
        }
    }
}
