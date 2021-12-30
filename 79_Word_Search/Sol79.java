public class Sol79 {
    public static void main(String[] args) {
        String[] words1 = {"ABCCED", "SEE", "ABCB"};
        char[][] board1 = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};

        WordSearch1 wordSearch1 = new WordSearch1();
        for(String word : words1){
            System.out.println(wordSearch1.exists(board1, word));
        }


        char[][] board2 = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words2 = {"oath","pea","eat","rain"};

        WordSearch2 wordSearch2 = new WordSearch2();
        System.out.println(wordSearch2.findWords(board2, words2));

    }
}