// https://leetcode.com/problems/insert-delete-getrandom-o1
class RandomizedSet {
    // K -> Val, V -> idx 
    private Map<Integer, Integer> map;
    private ArrayList<Integer> list;
    private Random rnd;
    private int idx;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rnd = new Random();
        idx = 0;
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, idx);
        list.add(val);
        idx += 1;
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int valIdx = map.get(val);
        int lastElem = list.get(idx - 1);
        
        list.set(valIdx, lastElem);
        map.put(lastElem, valIdx);
        
        list.remove(idx - 1);
        idx -= 1;
        map.remove(val);
        
        return true;
    }
    
    public int getRandom() {
        int randomIdx = rnd.nextInt(idx);
        return list.get(randomIdx);
    }
}
