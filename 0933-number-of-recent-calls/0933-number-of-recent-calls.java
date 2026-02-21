class RecentCounter {

    private int[] pingTimes;
    int start;
    int end;

    public RecentCounter() {
        pingTimes = new int[10000];
        start = 0;
        end = 0;
    }
    
    public int ping(int t) {
        while (start < end && t - pingTimes[start] > 3000) {
            start++;
        }
        pingTimes[end++] = t;
        return end - start;
    }
}