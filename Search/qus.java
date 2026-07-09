package Search;

public class qus {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int left = 0;
        int right = arr .length -1;
        int mid = left + (right - left) / 2;
        int tar = 4;

        while(left<=right){
            
            mid = left + (right - left)/2;
            
            if(arr[mid]==tar){
                System.out.println(mid);
            }

            if(arr[mid]<tar){
               left = mid + 1;
            }

            else if(arr[mid]>tar){
                right = mid - 1;
            }

        }
    }
}
