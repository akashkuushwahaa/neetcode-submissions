public class Pair{
    String word ;
    int distance;
    Pair(String word , int distance){
        this.word = word;
        this.distance = distance;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        HashSet<String> hash = new HashSet<>();
        for(String word : wordList){
            hash.add(word);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord , 1));
        while(!queue.isEmpty()){
            Pair element = queue.poll();
            String word = element.word;
            int distance = element.distance;
            int size = word.length();
            char[] words = new char[size];
            words = word.toCharArray();
            for(int i = 0;i<size;i++){
                for(char ch = 'a';ch<='z';ch++){
                    words[i] = ch;
                    String sb = new String(words);
                    if(sb.equals(endWord)){
                        return distance+1;
                    }
                    if(hash.contains(sb)){
                        queue.add(new Pair(sb , distance+1));
                        hash.remove(sb);
                    }
                }
                words = word.toCharArray();
            }
        }
        return 0;
    }
}