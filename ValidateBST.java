// https://leetcode.com/problems/validate-binary-search-tree/
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ValidateBST {
    private void listOfValues(List<Integer> values, TreeNode root) {
        if (root == null) {
            return;
        }
        listOfValues(values, root.left);
        values.add(root.val);
        listOfValues(values, root.right);
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        listOfValues(list, root);
        Integer prevVal = null;
        for (Integer e : list) {
            if (prevVal != null && e <= prevVal) return false;
            prevVal = e;
        }
        return true;
    }
}
