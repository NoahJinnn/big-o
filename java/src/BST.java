public class BST {

    private TreeNode createNode(int key) {
        return new TreeNode(key);
    }

    public TreeNode createBST(int[] arr) {
        TreeNode root = null;
        for(int i = 0; i < arr.length; i++) {
            insertNode(root, arr[i]);
        }
        return root;
    }

    public TreeNode insertNode(TreeNode root, int nodeKey) {
        if(root == null) {
            return createNode(nodeKey);
        }
        if(nodeKey > root.key) {
            root.right = insertNode(root.right, nodeKey);
        } else if(nodeKey < root.key) {
            root.left = insertNode(root.left, nodeKey);
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int nodeKey) {
        if(root == null) {
            // delete leaf
            return root;
        } else if(nodeKey < root.key) {
            root.left = deleteNode(root.left, nodeKey);
        } else if(nodeKey > root.key) {
            root.right = deleteNode(root.right, nodeKey);
        } else {
            // delete node with 1 child node
          if(root.left == null) {
              TreeNode temp = root.right;
              root = null;
              return temp;
          } else if(root.right == null) {
              TreeNode temp = root.left;
              root = null;
              return  temp;
          }
          // delete node with multiple child nodes (>= 2)
          TreeNode smallestRight = minValueNode(root.right);
          root.key = smallestRight.key;
          root.right = deleteNode(root.right, smallestRight.key);
        }
        return root;
    }

    private TreeNode minValueNode(TreeNode root) {
        TreeNode current = root;
        while(current.left != null) {
            current = root.left;
        }
        return  current;
    }

    public void printInOrder(TreeNode node) {
        if(node == null) return;
        printInOrder(node.left);
        System.out.println(node.key);
        printInOrder(node.right);
    }

    public void printPreOrder(TreeNode node) {
        if(node == null) return;
        System.out.println(node.key);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public void postPreOrder(TreeNode node) {
        if(node == null) return;
        postPreOrder(node.left);
        postPreOrder(node.right);
        System.out.println(node.key);
    }

}

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}
