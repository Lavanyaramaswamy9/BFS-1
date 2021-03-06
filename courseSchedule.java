/* Time complexity: O(n)
space complexity: O(V+E)
*/
class Solution{
    public boolean canFinish(int numCourses, int[][]prerequisites){
        if(prerequisites == null || prerequisites.length == 0) return true;
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : prerequisites){
            indegrees[edge[0]] ++;
            if(!map.containsKey(edge[i])){
                map.put(edge[i], new ArrayList<>());
            }
            map.get(edge[i]).add(edge[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i] == 0){
                q.add(i);
            }
        }

        if(q.size() == 0) return false;
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> children = map.get(curr);
            if(children != null){
                for(int child : children){
                    indegrees[child]--;
                    if(indegrees[child] == 0){
                        q.add(child);
                    }
                }
            }
        }
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i] > 0) return false;
        }

        return true;
    }
}