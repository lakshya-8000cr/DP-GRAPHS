import java.util.*;
class primary{

    private Map<Integer , List<Integer>>adjst ;


    public primary(){
        adjst = new HashMap<>();
    }

    public void addVertex(int node){
        adjst.putIfAbsent(node , new ArrayList<>());
    }

    public void addEdge(int x , int y){
        adjst.get(x).add(y);
        adjst.get(y).add(x);
    }
    public List<Integer> getNeighbour(int node){
        return adjst.get(node);
    }

    public void printgraph(){
        for(int node : adjst.keySet()){
            System.out.print(node  + " : " + adjst.get(node)) ;
        }
    }
    public static void main(String[] args){
         primary g = new primary();
        
        // Nodes banao
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);

        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        
        g.printgraph();

        System.out.println("get nose 1 neighbours" + g.getNeighbour(1));
    }
}