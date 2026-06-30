import java.util.ArrayList;

class gc{
    public static void main(String[] args){
       ArrayList<Integer> ls = new ArrayList<>();
       ArrayList<Integer> ls2 = new ArrayList<>();

       int a = 12;
       int b = 18;

       for(int i=1; i<=b; i++){
        if(a % i == 0 && b % i == 0) ls.add(i);
       };
       
     
    }
}