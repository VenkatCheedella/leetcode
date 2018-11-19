package com.leetcode.popularAlgos;

public class Trie {

    TrieNode root = null;

    class TrieNode{

        boolean isWord;
        TrieNode[] children;

        public TrieNode(){
            this.isWord = false;
            children = new TrieNode[26];
        }

        public boolean wordStatus(){
            return this.isWord;
        }

        public void setWord(){
            this.isWord = true;
        }

    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode currRoot = root;
        for(int i =0; i < word.length(); ++i){
            if(currRoot.children[word.charAt(i) - 97] == null){
                TrieNode newNode = new TrieNode();
                currRoot.children[word.charAt(i) - 97] = newNode;
                currRoot = newNode;
            }
            else{
                currRoot = currRoot.children[word.charAt(i) - 97];
            }
        }
        currRoot.setWord();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode currRoot = root;
        for(int i =0 ; i < word.length(); i++){
            if(currRoot == null || currRoot.children[word.charAt(i) - 97] == null){
                return false;
            }
            else {
                currRoot = currRoot.children[word.charAt(i) - 97];
            }
        }
        return currRoot.wordStatus();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode currRoot = root;
        for(int i=0; i< prefix.length(); i++){
            if(currRoot == null || currRoot.children[prefix.charAt(i)- 97] == null){
                return false;
            }
            else{
                currRoot =  currRoot.children[prefix.charAt(i) - 97];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("cd"));
    }
}
