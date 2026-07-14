package Search ;
public class ro {
    public static void main(String[] args){
        String r = "Lak";

        int st = 0;
        int end = r.length()-1;

        while(st<end){
           char c =  r.charAt(st);
           char v =  r.charAt(end);

            char temp = c;
            c = v ;
            v = temp;

            st++;
            end--;
        }

        System.out.print(r);
    }
}
