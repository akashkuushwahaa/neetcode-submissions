class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        int maxfreq=0;
        for(char c: tasks){
            freq[c-'A']++;
            maxfreq=Math.max(maxfreq,freq[c-'A']);
        } 
        int maxCount=0;
        for(int f:freq){
            if(f==maxfreq)
            maxCount++;
        }
        int slots=(maxfreq-1)*(n+1)+maxCount;
        return Math.max(tasks.length, slots);
    }
}