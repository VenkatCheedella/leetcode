package com.leetcode.popularAlgos;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = createTrie(words);
        for(int i=0; i< board.length; i++){
            for(int j =0; j< board[0].length; j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }


    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result){
        char curr = board[i][j];
        if(curr == '#' || root.children[curr - 'a'] == null){
            return;
        }
        TrieNode next =  root.children[curr - 'a'];
        if(next.word != null){
            result.add(next.word);
            next.word = null;
        }

        board[i][j] = '#';
        if(i > 0) dfs(board, i-1, j, next, result);
        if(i < board.length-1) dfs(board, i+1, j, next, result);
        if(j > 0) dfs(board, i, j-1, next, result);
        if(j < board[0].length-1) dfs(board, i, j+1, next, result);
        board[i][j] = curr;

    }

    private TrieNode createTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode temp = root;
            for(char c : word.toCharArray()){
                if(temp.children[c- 'a'] == null){
                    temp.children[c - 'a'] = new TrieNode();
                }
                temp = temp.children[c - 'a'];
            }
            temp.word = word;
        }
        return root;
    }


    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','a'},{'i','h','b','d'},{'i','f','e','n'}};
        String[] words = {"oath","pea","eat","benda"};
        WordSearch wrdsrch = new WordSearch();
        System.out.println(wrdsrch.findWords(board, words));
    }
}
