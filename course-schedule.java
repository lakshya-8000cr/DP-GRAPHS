/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //we are going to do thi question , but first we will discuss the logic 
        //1-> this question simply just says that if toposort is possible or not 
        //2-> logic -> count the number of t courses when you are in the queue , 
        //if the the courses is equal to the numCourses it means topo sort possible

        //prepare the list
        ArrayList<ArrayList<Integer>> ls = new ArrayList<>();

        for(int i=0; i<numCourses ; i++){
            ls.add(new ArrayList<>());
        }

        //create the indegree array
        int[] indegree = new int[numCourses + 1];

        //populate the list
        for(int[] edge : prerequisites){
            // we have directed graph for the logic 
            int a = edge[0];
            int b = edge[1];

            //we will point toward the b it meansindegree of b will be counted
            ls.get(a).add(b);

            indegree[b]++;
        }

        //queueq
        Queue<Integer> q = new LinkedList<>();

        //now iterate thru the preqiuehiwhifehwiufeh
        //push all the ele in queue which have indegree = 0
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int cnt = 0;

        //bfs logic
        while(!q.isEmpty()){
            int cutt = q.poll();
             cnt++;

             //iterate thru the neighbour
             for(int neigh : ls.get(cutt)){
                 //curr is removed now decrease the indegree of thier neigbiur
                 indegree[neigh]--;
                 
                 if(indegree[neigh]==0){
                    q.add(neigh);
                 }
             }
             
        }

        return cnt==numCourses;
    }
}
// @lc code=end

