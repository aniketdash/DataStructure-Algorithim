/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        Queue<Node> q= new LinkedList<>();
        Map<Node,Node> mp = new HashMap<>();
        q.offer(node);
        mp.put(node,new Node(node.val,new ArrayList<>()));
        while(!q.isEmpty()){
            Node curr=q.poll();
            for(Node n:curr.neighbors){
                if(!mp.containsKey(n)){
                    mp.put(n,new Node(n.val,new ArrayList<>()));
                    q.offer(n);
                }
                mp.get(curr).neighbors.add(mp.get(n));
                    
            }
        }
        return mp.get(node);
    }
}