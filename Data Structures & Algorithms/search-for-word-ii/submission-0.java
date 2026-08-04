class TrieNode {
    TrieNode[] root = new TrieNode[26];
    boolean isWord = false;
    String word = null;

    boolean containsKey(char ch) {
        return root[ch - 'a'] != null;
    }

    void put(TrieNode node, char ch) {
        root[ch - 'a'] = node;
    }

    TrieNode get(char ch) {
        return root[ch - 'a'];
    }

    void setEnd(String word) {
        this.word = word;
        isWord = true;
    }

    boolean isEnd() {
        return isWord;
    }
}

class Solution {
    final int[][] diff = {
        {0, -1}, {0, 1},
        {-1, 0}, {1, 0}
    };

    public void insert(String word, TrieNode root) {
        TrieNode node = root;
        int N = word.length();
        for (int i = 0; i < N; i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(new TrieNode(), ch);
            }
            node = node.get(ch);
        }
        node.setEnd(word);
    }

    public void dfs(char[][] board, boolean[][] visited, int R, int C, int row, int col, TrieNode root, Set<String> result) {
        TrieNode node = root.get(board[row][col]);
        if(node == null) return;
        if(node.isWord) {
            result.add(node.word);
            node.isWord = false;
        }
        visited[row][col] = true;
        for(int i = 0 ; i < 4 ; i++) {
            int adjR = row + diff[i][0];
            int adjC = col + diff[i][1];
            if(adjR < R && adjR >= 0 && adjC < C && adjC >= 0 && !visited[adjR][adjC]) {
                dfs(board, visited, R, C, adjR, adjC, node, result);
            }
        }
        visited[row][col] = false;

    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            insert(word, root);
        }
        int R = board.length;
        int C = board[0].length;
        boolean[][] visited = new boolean[R][C];
        Set<String> result = new HashSet<>();
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                dfs(board, visited, R, C, i, j, root, result);
            }
        }
        return new ArrayList<>(result);
    }
}