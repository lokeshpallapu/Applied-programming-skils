class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int i:nums){
            if(map.containsKey(i)){
              map.put(i,map.get(i)+1);
            }
            else{
                map.put(i,1);
            }
        }
        Map <Integer,List<Integer>> map1 = new HashMap<>();
        for(int x:map.keySet()){
            int count = map.get(x);
            if(map1.containsKey(count)){
                map1.get(count).add(x);
            }
            else{
                map1.put(count,new ArrayList<Integer>());
                map1.get(count).add(x);
            }
        }
        int [] arr = new int[k];
        int index=0;
        for(int i=nums.length;i>=1;i--){
            if(map1.containsKey(i)){
                for(int y: map1.get(i)){
                    if(index<k){
                        arr[index] = y;
                        index++;
                    }
                    else{
                        break;
                    }
                }
                if(index>=k){
                    break;
                }
            }
        }
          return arr;
    }
}