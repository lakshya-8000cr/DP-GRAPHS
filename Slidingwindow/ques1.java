import java.util.*;
class ques1{
     public static int main(String[] args){
        int[] arr = {1,2,3,4,5};
        int currsum = 0;
        int maxlength = 0;
        int left =0;
        int right =0;
        int tar = 9;

        while(right<=arr.length){
            currsum += arr[right]; // add the current sum move the right forward

            while(currsum<=tar){
                currsum -= arr[left];
                left++; // decrease the left; 
            }

            int window = left - right + 1;
            maxlength = Math.max(window , maxlength);
            right++; //increase the right
        }

        return maxlength;
     }
}