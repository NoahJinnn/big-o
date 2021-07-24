public class Trie {
    public TrieNode insertTrie(String str) {
        TrieNode root = new TrieNode();
        TrieNode temp = root;

        for(int i = 0; i < str.length(); i++) {
            int childIdx = str.charAt(i) - 'a';
            if(temp.childs[childIdx] == null) {
                temp.childs[childIdx] = new TrieNode();
            }
            temp = temp.childs[childIdx];
        }
        temp.key += 1; // mark as end of word

        return root;
    }

    public boolean findString(TrieNode root, String str) {
        TrieNode temp = root;
        for(int i = 0; i < str.length(); i++) {
            int childIdx = str.charAt(i) - 'a';
            if(temp.childs[childIdx] == null) return false;
            temp = temp.childs[childIdx];
        }
        return temp.key > 0;
    }

    public boolean removeString(TrieNode root, String str, int level) {
        if(root == null) return false;
        if(level == str.length()) {
            if(root.key > 0) {
                root.key--;
                return true;
            }
            return false;
        }
        int childIdx = str.charAt(level) - 'a';
        boolean flag = removeString(root.childs[childIdx], str, level + 1);
        if(flag && root.childs[childIdx].key == 0 && isEmpty(root.childs[childIdx])) {
            root.childs[childIdx] = null;
        }
        return flag;
    }

    private boolean isEmpty(TrieNode node) {
        for(int i = 0; i < node.childs.length; i++) {
            if(node.childs[i] != null) return false;
        }
        return true;
    }

}

class TrieNode {
    int key;
    TrieNode[] childs = new TrieNode[26]; // responding 26 character

    public TrieNode() {
    }


}