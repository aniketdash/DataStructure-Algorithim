class Solution {
    List<Integer> res;
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        res=new ArrayList();
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int i=0;i<pid.size();i++){
            List<Integer> temp=graph.getOrDefault(ppid.get(i),new ArrayList<>());
            temp.add(pid.get(i));
            graph.put(ppid.get(i),temp);
            List<Integer> cTemp=graph.getOrDefault(pid.get(i),new ArrayList<>());
            graph.put(pid.get(i),cTemp);
        }
        dfs(kill,graph);
        return res;
    }
    public void dfs(int kill, Map<Integer,List<Integer>> graph){
        res.add(kill);
        for(int i:graph.get(kill)){
            dfs(i,graph);
        }
    }
}