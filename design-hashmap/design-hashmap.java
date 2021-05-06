class MyHashMap {
    LinkedList<List<Integer>>[] bucket;
    int mod=11169;
    /** Initialize your data structure here. */
    public MyHashMap() {
        bucket=new LinkedList[mod];
        for(int i=0;i<bucket.length;i++)
            bucket[i]=new LinkedList();
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        boolean flag=false;
        Iterator i=bucket[key%mod].iterator();
        while(i.hasNext()){
            List<Integer> li=(List<Integer>)i.next();
            if(li.get(0)==key){
                li.set(1,value);
                flag=true;
                break;
            }
        }
        if(!flag){
            List<Integer> temp=new ArrayList();
            temp.add(key);
            temp.add(value);
            bucket[key%mod].add(temp);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Iterator i=bucket[key%mod].iterator();
        while(i.hasNext()){
            List<Integer> li=(List<Integer>)i.next();
            if(li.get(0)==key){
                return li.get(1);
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Iterator i=bucket[key%mod].iterator();
        while(i.hasNext()){
            List<Integer> li=(List<Integer>)i.next();
            if(li.get(0)==key){
                i.remove();
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */