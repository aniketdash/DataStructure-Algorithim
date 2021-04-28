class RandomizedSet {
    Map<Integer,Integer> lookup;
    List<Integer> li;
    Random rand=new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        lookup=new HashMap<>();
        li=new ArrayList();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(lookup.containsKey(val)) return false;
        
        lookup.put(val,li.size());
        li.add(li.size(),val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!lookup.containsKey(val)) return false;
        
        int index=lookup.get(val);
        int last=li.get(li.size()-1);
        lookup.put(last,index);
        li.set(index,last);
        li.remove(li.size()-1);
        lookup.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return li.get(rand.nextInt(li.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */