package CODELAB_TREE;

public class BinaryTreeExercise {

    // ==================================================================================
    // HISTORY OF MAJAPAHIT: THE GOLDEN ERA
    // ==================================================================================
    // Scenario: We are building a "Royal Chronicle" (Kitab Negarakertagama) to
    // index
    // the important figures of the Majapahit Empire using a Binary Search Tree
    // (BST).

    // FUNDAMENTAL THEORY:
    // ----------------------------------------------------------------------------------
    // 1. NODE : Basic unit of data storage (Example: "Raden Wijaya").
    // 2. ROOT : The topmost/starting node (Example: "Raden Wijaya" as the founder).
    // 3. CHILD : A node directly connected below another node (Example:
    // "Jayanegara").
    // 4. LEAF : A node with no children (The end of a branch, e.g., "Gajah Mada").
    // 5. INTERNAL NODE : A node with at least one child (Not a Leaf).
    // 6. EDGE : The connection link between two nodes.
    // 7. LEVEL : The depth rank (Root = Level 0).
    // 8. HEIGHT : The longest path from a Node to the deepest Leaf.
    // 9. DEPTH : The path length from Root to a specific Node.
    // 10. SUBTREE : A smaller tree formed by a node and its descendants.
    // 11. SIBLING : Nodes that share the same Parent.
    // 12. ANCESTOR : All nodes above a specific node.
    // 13. DESCENDANT : All nodes below a specific node.

    // ==================================================================================
    // EXERCISE: IMPLEMENT THE ROYAL CHRONICLE
    // ==================================================================================

    static class Node {
        String name;
        Node left;
        Node right;

        public Node(String name) {
            this.name = ____;
            this.left = ____;
            this.right = ____;
        }
    }

    private Node root;

    public void insert(String name) {
        root = insertRec(root, name);
    }

    private Node insertRec(Node root, String name) {
        if (root == ____) {
            root = new Node(____);
            return root;
        }

        if (name.compareTo(root.name) < 0) {
            root.left = insertRec(root.left, ____);
        } else if (name.compareTo(root.name) > 0) {
            root.right = insertRec(root.right, ____);
        }

        return root;
    }

    // ==================================================================================
    // PERMINTAAN TAMBAHAN (Extra Features)
    // ==================================================================================

    // 1. SEARCH (Mencari Tokoh)
    public boolean search(String name) {
        return searchRec(root, name);
    }

    private boolean searchRec(Node root, String name) {
        if (root == null)
            return ____;
        if (root.name.equals(name))
            return ____;

        if (name.compareTo(root.name) < 0)
            return searchRec(root.____, name);

        return searchRec(root.____, name);
    }

    // 2. FIND MIN & MAX (Tokoh Awal & Akhir Abjad)
    public String findMin() {
        return findMinRec(root);
    }

    private String findMinRec(Node root) {
        if (root.left == ____) {
            return root.name;
        }
        return findMinRec(root.____);
    }

    public String findMax() {
        return findMaxRec(root);
    }

    private String findMaxRec(Node root) {
        if (root.right == ____) {
            return root.name;
        }
        return findMaxRec(root.____);
    }

    // 3. DELETION (Menghapus Tokoh) -> ADVANCED
    public void delete(String name) {
        root = deleteRec(root, name);
    }

    private Node deleteRec(Node root, String name) {
        if (root == null)
            return root;

        if (name.compareTo(root.name) < 0) {
            root.left = deleteRec(root.left, name);
        } else if (name.compareTo(root.name) > 0) {
            root.right = deleteRec(root.right, name);
        } else {
            // Node Found
            // Case 1: No child or 1 child
            if (root.left == null)
                return root.____;
            if (root.right == null)
                return root.____;

            // Case 2: Two children
            root.name = findMinRec(root.right);
            root.right = deleteRec(root.right, root.name);
        }
        return root;
    }

    // ==================================================================================
    // TRAVERSALS
    // ==================================================================================

    // A) InOrder (Alphabetical / Chronological in BST)
    public void inOrder() {
        System.out.println("\n1. InOrder (Alphabetical Sort):");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != ____) {
            inOrderRec(root.____);
            System.out.print(root.name + " -> ");
            inOrderRec(root.____);
        }
    }

    // B) PreOrder (Government Structure / Hierarchy)
    public void preOrder() {
        System.out.println("\n2. PreOrder (Royal Decree Structure):");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != ____) {
            System.out.print(root.____ + " -> ");
            preOrderRec(root.____);
            preOrderRec(root.____);
        }
    }

    // C) PostOrder (Historical Archives / Bottom-Up)
    public void postOrder() {
        System.out.println("\n3. PostOrder (Historical Archives):");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != ____) {
            postOrderRec(root.____);
            postOrderRec(root.____);
            System.out.print(root.____ + " -> ");
        }
    }

    public static void main(String[] args) {
        BinaryTreeExercise majapahit = new BinaryTreeExercise();

        // 1. Display Terminology
        System.out.println(">>> KITAB NEGARAKERTAGAMA: MAJAPAHIT DYNASTY <<<");
        System.out.println("[Theory] Root: Founding Father, Leaves: The Legacy...");

        // 2. Insert Historical Figures (BST Logic: A-Z)
        // Root: Raden Wijaya
        majapahit.insert("Raden Wijaya");

        // Left Branch (< R)
        majapahit.insert("Jayanegara"); // J < R
        majapahit.insert("Gajah Mada"); // G < J
        majapahit.insert("Kertanegara"); // K > J, K < R

        // Right Branch (> R)
        majapahit.insert("Tribhuwana"); // T > R

        // H < R, H < J, H > G -> Right of Gajah Mada
        majapahit.insert("Hayam Wuruk");

        // VISUALIZATION (ASCII)
        System.out.println("\n[Structure Visualization (BST Alphabetical)]");
        System.out.println("        Raden Wijaya (Root)");
        System.out.println("        /           \\");
        System.out.println("   Jayanegara    Tribhuwana");
        System.out.println("   /        \\");
        System.out.println("Gajah Mada  Kertanegara");
        System.out.println("    \\");
        System.out.println("   Hayam Wuruk");

        // 3. Execute Traversals
        majapahit.inOrder();
        majapahit.preOrder();
        majapahit.postOrder();

        // 4. Test New Features (Search, Min, Max, Delete)
        System.out.println("\n>>> UPDATING CHRONICLES (SEARCH & DELETE) <<<");

        // Search
        System.out.println("Is 'Gajah Mada' in the tree? " + (majapahit.search("Gajah Mada") ? "YES" : "NO"));
        System.out.println("Is 'Lembu Sora' in the tree? " + (majapahit.search("Lembu Sora") ? "YES" : "NO"));

        // Min/Max
        System.out.println("First Alphabetical Name: " + majapahit.findMin());
        System.out.println("Last Alphabetical Name:  " + majapahit.findMax());

        // Delete
        System.out.println("Removing 'Jayanegara' from history...");
        majapahit.delete("Jayanegara");
        majapahit.inOrder(); // Verify removal
    }
}
