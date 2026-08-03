class WordDictionary {
    Node root;
    class Node {
        char c;
        Node[] child;
        boolean isWord = false;

        Node(char c) {
            this.c = c;
            this.child = new Node[26];
        }
    }

    public WordDictionary() {
        root = new Node('#');
    }

    public void addWord(String word) {
        addWord(word, 0, root);
    }

    private void addWord(String word, int index, Node node) {
        if (word.length() == index) {
            node.isWord = true;
            return;
        }

        char ch = word.charAt(index);
        int c = ch - 'a';
        Node child = node.child[c];
        if (child == null) {
            child = new Node(ch);
            node.child[c] = child;
        }

        addWord(word, index + 1, child);

    }

    boolean searchWord(String word, int index, Node node) {
        if (word.length() == index) {
            return node.isWord;
        }
        char ch = word.charAt(index);
        boolean found = false;
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                Node child = node.child[i];
                if (child != null)
                    found = found || searchWord(word, index + 1, child);
            }
        } else {
            int c = ch - 'a';
            Node child = node.child[c];
            if (child == null) {
                return false;
            }
            found = searchWord(word, index + 1, child);
        }
        return found;
    }

    public boolean search(String word) {
        return searchWord(word, 0, root);
    }
}
