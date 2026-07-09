package Search;

public class firstlaast {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,4,5};
        int tar = 4;
        int st = 0;
        int end = arr.length - 1;
        int mid = st +  (end - st) / 2;
        int first = -1;
        int lst = -1;

        while(st<=end){
            mid = st + (end - st)/2;

            if(arr[mid]==tar){
               first = mid ;
               end = mid - 1;
            }

            else if(arr[mid]<tar){
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }

        }

        //for the last
        while(st<=end){
            mid = st + (end - st)/2;

            if(arr[mid]==tar){
               lst = mid ;
               st = mid + 1;
            }

            else if(arr[mid]<tar){
                end = mid - 1;
            }
            else{
                st = mid + 1;
            }

        }
        
    }
}
