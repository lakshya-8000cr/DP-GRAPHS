package Search;

public class Solution {
    
    public int mySqrt(int x) {
        int st = 1;
        int end = x;
        int mid = st + (end - st)/2;
        int ans = -1;
        
        while(st<=end){
            mid  = st + ( end - st )/ 2;
            
            if(mid * mid == x){
                return mid ;
            }
            else if(mid * mid < x){
                ans = mid; 
                st = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        return ans; 
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.mySqrt(4));
        System.out.println(sol.mySqrt(8));
    }
}