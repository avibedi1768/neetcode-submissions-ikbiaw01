class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> hm = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>();

        for(int p : hand){
            hm.put(p, hm.getOrDefault(p, 0) + 1);
            pq.add(p);
        }

        while(!pq.isEmpty()){
            int curr = pq.remove();

            if(hm.containsKey(curr)){
                for(int i = 0; i < groupSize; i++){
                    if(!hm.containsKey(curr + i))
                        return false;
                    
                    int rem = hm.get(curr + i) - 1;

                    if(rem == 0)
                        hm.remove(curr + i);
                    else
                        hm.put(curr + i, rem);
                }
            }
        }

        return true;
    }
}
