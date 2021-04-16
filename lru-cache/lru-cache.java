class LRUCache {
    
    class DlinkedNode {
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;
    }
    
    private void addNode(DlinkedNode node){
        node.prev=head;
        node.next=head.next;
        
        head.next.prev=node;
        head.next=node;
    }
    
    private void removeNode(DlinkedNode node){
        DlinkedNode prev= node.prev;
        DlinkedNode next= node.next;
        
        prev.next=next;
        next.prev=prev;
    }
    
    private void moveToHead(DlinkedNode node){
        removeNode(node);
        addNode(node);
    }
    
    private DlinkedNode popTail(){
        DlinkedNode n=tail.prev;
        removeNode(n);
        return n;
    }
    
    private Map<Integer,DlinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DlinkedNode head,tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head= new DlinkedNode();
        tail= new DlinkedNode();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        DlinkedNode node= cache.get(key);
        if(node == null) return -1;
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DlinkedNode node= cache.get(key);
        
        if(node==null){
            DlinkedNode newNode = new DlinkedNode();
            newNode.key=key;
            newNode.value=value;
            cache.put(key,newNode);
            addNode(newNode);
            
            ++size;
            
            if(size>capacity){
                DlinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        }else{
            node.value=value;
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */