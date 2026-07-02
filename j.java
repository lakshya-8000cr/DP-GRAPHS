public class j {
    public static void main(){
        int[] arr = {1,2,3,4,5,6};

        for(int i=0; i<arr.length; i++){
            for(int j = i; j<i+2; j++){
                System.out.print(arr[j] + " ");
            }

            System.out.println();
        }
    }
}
