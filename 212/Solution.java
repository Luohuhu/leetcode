import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> result1 = new ArrayList<String>();
    List<String> result = new ArrayList<String>();
    public List<String> findWords(char[][] board, String[] words) {
        //System.out.println(board.length+" "+board[0].length);
        for (int i=0; i<words.length; i++){
            if (words[i].length()==1){
                boolean isVisited = false;
                for (int k=0; k<board.length; k++){
                    if (isVisited) break;
                    for (int j=0; j<board[k].length; j++){
                        if (board[k][j]==words[i].charAt(0)){
                            result.add(words[i]);
                            isVisited = true;
                            break;
                        }
                    }
                }
            }else {
                if (isExisted(board,words[i])){
                    result.add(words[i]);
                }
            }
        }
        return result;
    }
    public boolean isExisted(char[][] board, String word){
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if (board[i][j]==word.charAt(0)){
                    boolean[][] visited= new boolean[board.length][board[i].length];
                    helper(board, i, j, word, 0, visited);
                    if (result1.size()>0&&result1.get(result1.size()-1).equals(word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void helper(char[][] board, int i, int j, String word, int num, boolean[][] visited){

        if (num==word.length()-1){
            //System.out.println(word);
            if (board[i][j]==word.charAt(num)&&!visited[i][j]) result1.add(word);
            return;
        }
        if (num<word.length()&&word.charAt(num)==board[i][j]&&!visited[i][j]){
            visited[i][j]=true;
            boolean[][] newVisited= new boolean[board.length][board[i].length];
            //boolean[][] newVisited = visited;
            if (i<board.length-1){
                for (int k=0; k<board.length; k++){
                    for (int m=0; m<board[k].length; m++){
                        newVisited[k][m]=visited[k][m];
                    }
                }
                helper(board, i+1, j, word, num+1, newVisited);
            }
            if (i>0){
                for (int k=0; k<board.length; k++){
                    for (int m=0; m<board[k].length; m++){
                        newVisited[k][m]=visited[k][m];
                    }
                }
                helper(board, i-1, j, word, num+1,  newVisited);
            }
            if (j<board[0].length-1){
                for (int k=0; k<board.length; k++){
                    for (int m=0; m<board[k].length; m++){
                        newVisited[k][m]=visited[k][m];
                    }
                }
                helper(board, i, j+1, word, num+1,  newVisited);
            }
            if (j>0){
                for (int k=0; k<board.length; k++){
                    for (int m=0; m<board[k].length; m++){
                        newVisited[k][m]=visited[k][m];
                    }
                }
                helper(board, i, j-1, word, num+1,  newVisited);
            }
        }else {
            return;
        }

    }
    public static void main(String[] arg) {
        char[][] board = {{'a'},{'a'}};
        String[] words = {"a"};
        System.out.println(new Solution().findWords(board,words));
    }
}
