class StockSpanner {
    private static class Pair {
        int price;
        int span;

        Pair(int price, int span) {
            this.price = price;
            this.span = span;
        }
    }

    private Stack<Pair> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek().price <= price){
            span += stack.pop().span;
        }
        stack.push(new Pair(price,span));
        return span;
    }
}