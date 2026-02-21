class Solution {
    public int[] finalPrices(int[] prices) {
        int len = prices.length;
        int[] monoStack = new int[len];
        monoStack[0] = prices[len - 1];
        int top = 0;

        for (int i = len - 2; i >= 0; i--) {
            while (top >= 0 && monoStack[top] > prices[i]) {
                top--;
            }

            monoStack[top + 1] = prices[i];

            if (top >= 0) {
                prices[i] -= monoStack[top];
            }

            top++;
        }
        return prices;
    }
}