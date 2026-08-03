class MedianFinder {

    PriorityQueue <Integer> min = new PriorityQueue<>();
    PriorityQueue <Integer> max = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(max.isEmpty())
            max.offer(num);
        else if(!max.isEmpty() && num <= max.peek()){
            max.offer(num);
        }
        else 
            min.offer(num);

        if(max.size() > min.size()+1){
            min.offer(max.poll());
        }

        if(min.size()> max.size())
            max.offer(min.poll());
    }
    
    public double findMedian() {
        if(max.size() == min.size()+1)
            return max.peek();
        return (double)(max.peek() + min.peek())/2;
    }
}