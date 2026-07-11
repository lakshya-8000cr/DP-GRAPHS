package P1;

public class Solution22 {
    public static void main(String[] args){
        int sum = 0;

        int n= 4;
        for(int i=1; i<=n; i++){
            int j = n/i;
            sum += i*j;
        }

        System.out.print(sum);
    }
}
