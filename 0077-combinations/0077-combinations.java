class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<(1<<n);i++){
            if(Integer.bitCount(i)==k){
                List<Integer> arr = new ArrayList<>();
                for(int j=1;j<=n;j++){
                    if ((i & (1 << (j - 1))) != 0) {
                        arr.add(j);
                    }
                }
                res.add(arr);
            }
        }
        return res;
    }
}