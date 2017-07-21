package com.sanjiv.sandbox.tries;

public class Tries {
    TrieNode root = null;

    public Tries() {
         this.root = new TrieNode();
    }

    private int findIndex(char c) {
        return c - 'a';
    }

    public TrieNode insert(String s) {
        TrieNode current = root;

        for (int ii = 0; ii < s.length(); ii++) {
            char c = s.charAt(ii);
            System.out.println("inserting char: "+ c);

            TrieNode next = current.next(c);

            if (next != null) {
                current = next;
            } else {
                next = new TrieNode();
                current.nodes[findIndex(c)] = next;
                current = next;
            }
        }
        current.endCount++;

        return root;
    }

    public int query(String s) {
        int result = -1;
        TrieNode current = root;

        for (int ii = 0; ii < s.length(); ii++) {
            char c = s.charAt(ii);
            TrieNode next = current.next(c);

            if (next != null) {
                current = next;
            } else {
                current = null;
                break;
            }
        }
        if (current != null) {
            result = current.endCount;
        }

        return result;
    }

    //"pqr", "pqs" "pq"


    public static class TrieNode {
        public TrieNode[] nodes = new TrieNode[26];
        public int endCount = 0;

        public TrieNode next(char c) {
            int index = c - 'a';
            if ((index >= 0) && (index < nodes.length)) {
                return nodes[index];
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Tries tries = new Tries();

        tries.insert("pq");
        tries.insert("pqr");
        tries.insert("pqs");
        tries.insert("pq");
        System.out.println("Query 'pqr': " + tries.query("pqr"));
        System.out.println("Query 'pqrs': " + tries.query("pqrs"));
        System.out.println("Query 'pq': " + tries.query("pq"));
    }
}
