package com.sanjiv.sandbox.tries;

/**
 * @author Sanjiv on 7/21/17.
 */
public class DictionarySearch {

    private Tries tries;

    public DictionarySearch() {
        this.tries = new Tries();
    }

    public void loadDictionary() {

        tries.insert("one");
        tries.insert("two");
        tries.insert("three");
    }

    public int spellCheck(String wordTOCheck) {
        return tries.query(wordTOCheck);
    }

    public static void main(String[] args) {
        DictionarySearch dicSearch = new DictionarySearch();
        dicSearch.loadDictionary();

        System.out.println("Result forspell check for word one: " + dicSearch.spellCheck("one")); // 1
        System.out.println("Result forspell check for word twt: " + dicSearch.spellCheck("twt")); // -1

    }


//  *******  Older try
//    private Trie dic;
//
//    public DictionarySearch(Trie dic) {
//        this.dic = dic;
//    }
//
//    public String spellChec(String word) {
//        String resultWord = "";
//        if (StringUtils.isEmpty(word)) {
//            throw new IllegalArgumentException("Wrd to spell check cannot be empty");
//        }
//
//        dic.
//    }
//
//    public static void main(String[] args) {
//        Map<String, Integer> dicMap = new HashMap<>();
//        dicMap.put("one", 1);
//        dicMap.put("blah", 2);
//        dicMap.put("cat", 3);
//        dicMap.put("dog", 4);
//        Trie dic = new PatriciaTrie(dicMap);
//
//         PatriciaTrie<AbstractCompletionProposalDisplayable> namespaceTrie;
//
//        DictionarySearch dicSearch = new DictionarySearch(dic);

}
