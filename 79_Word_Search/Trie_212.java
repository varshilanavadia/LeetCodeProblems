public class Trie_212 {
    TrieNode_212 root;

    public Trie_212(){
        root = new TrieNode_212(false);
    }

    public void addWord(String word){
        TrieNode_212 node = this.root;
        for(char c : word.toCharArray()){
            TrieNode_212 nextNode = node.neighbours.getOrDefault(c, new TrieNode_212(false));
            node.neighbours.putIfAbsent(c, nextNode);
            node = nextNode;
        }
        node.isWord = true;
    }
}
