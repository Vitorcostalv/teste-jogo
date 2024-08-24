import java.awt.Graphics;

public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(Platform platform) {
        root = insertRec(root, platform);
    }

    private TreeNode insertRec(TreeNode root, Platform platform) {
        if (root == null) {
            root = new TreeNode(platform);
            return root;
        }

        if (platform.getBounds().x < root.platform.getBounds().x) {
            root.left = insertRec(root.left, platform);
        } else {
            root.right = insertRec(root.right, platform);
        }

        return root;
    }

    // Método público para acessar o nó raiz
    public TreeNode getRoot() {
        return root;
    }

    public void traverseAndDraw(Graphics g) {
        traverseAndDrawRec(root, g);
    }

    private void traverseAndDrawRec(TreeNode node, Graphics g) {
        if (node != null) {
            traverseAndDrawRec(node.left, g);
            node.platform.draw(g);
            traverseAndDrawRec(node.right, g);
        }
    }
}
