package com.crystalsantos.coding.trees;

public class SymetricTree {

	public class TreeNode {
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
	
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return false;
        }
        
        if(root != null && root.left == null && root.right == null) {
            return true;
        }
        
        return isMirror(root, root);
    }
    
    private boolean isMirror(TreeNode nodeLeft, TreeNode nodeRight) {
        if (nodeLeft == null && nodeRight == null) {
            return true;
        }

        if (nodeLeft != null && nodeRight != null && nodeLeft.val == nodeRight.val) {
            return (isMirror(nodeLeft.left, nodeRight.right)
                    && isMirror(nodeLeft.right, nodeRight.left));
        }

        return false;
    }
}
