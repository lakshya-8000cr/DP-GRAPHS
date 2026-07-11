package P1;

public class Solution21 {

    public static boolean c(int n , int k){
        int d = 0;
        while(n!=0){
            d++;
            n = n / 10;
        }

        return (d==k);
    }
    public static void main(String[] args){
        int[] arr = {10,22,3,4,1,6,7,8,5,33,4,99,100};

        int k = 2;
        int cnt = 0;

        for(int i=0; i<arr.length; i++){
            if(c(arr[i],k)){
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
