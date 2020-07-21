import java.util.Scanner;

public class ArrayMax {
    public static void main(String[] args) {
        int []arr = new int[5];
        int max;
        System.out.println("enter Arrray elements");
        Scanner Sc = new Scanner(System.in);
        for(int i=0;i<5;i++){
            arr[i] = Sc.nextInt();
        }
        max = MaxxArr(arr);

        System.out.println("\nMax is : "+max);
    }
    public static int MaxxArr(int arr[]){
        int max = arr[0];
        for(int i=0;i<5;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }

}
