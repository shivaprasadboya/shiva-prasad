import java.util.*;
import java.util.LinkedList;
// import org.w3c.dom.Node;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }

    }

    public static Node root;

    public static void levelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);

        }
    }

    public static void inOrderRecur(Node root) {
        if (root == null)
            return;
        inOrderRecur(root.left);
        System.out.print(root.data + " ");
        inOrderRecur(root.right);

    }

    public static void postOrderRecur(Node root) {
        if (root == null)
            return;
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.print(root.data + " ");

    }

    public static void inOrderTravlot() {
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        Node cur = root;
        while (cur != null || st.size() > 0) {
            while (cur != null) {
                st.add(cur);
                cur = cur.left;
            }
            cur = st.pop();
            al.add(cur.data);
            cur = cur.right;
        }
        System.out.print(al + " ");
    }

    public static void preOrderTraversal(Node root) {
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        if (root == null)
            System.out.println(al);
        st1.push(root);
        while (!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);
            if (root.left != null)
                st1.push(root.left);
            if (root.right != null)
                st1.push(root.right);
        }
        while (!st2.isEmpty()) {
            al.add(st2.pop().data);
        }
        System.out.println(al);
    }

    public static void postOrderTraversal(Node root) {
        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0, root.data);
        q1.add(root.left);
        q2.add(root.right);
        while (!q1.isEmpty()) {
            Node temp = q1.remove();
            al.add(temp.data);
            if (temp.left != null)
                q1.add(temp.left);
            if (temp.right != null)
                q1.add(temp.right);
        }
        while (!q2.isEmpty()) {
            Node temp = q2.remove();
            al.add(temp.data);
            if (temp.left != null)
                q2.add(temp.left);
            if (temp.right != null)
                q2.add(temp.right);
        }

        System.out.println(al);

    }

    public static int sumBinaryTree(Node root) {
        if (root == null)
            return 0;
        return sumBinaryTree(root.left) + sumBinaryTree(root.right);
    }

    public static void sumOfAllNodes(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int sum = 0;
        while (!q.isEmpty()) {
            Node temp = q.remove();
            sum += temp.data;
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);

        }
        System.out.println(sum);

    }

    public static void countNodesInTree(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while (!q.isEmpty()) {
            Node temp = q.remove();
            count++;
            if (temp.left != null)
                q.add(temp.left);
            if (temp.right != null)
                q.add(temp.right);

        }
        System.out.println(count);

    }

    public static void printCorner(Node root) {

    }

    public static void main(String args[]) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        // --------------------------------//
        // levelOrderTraversal(root);
        // sumOfAllNodes(root);
        countNodesInTree(root);
        // inOrdertraversal(root);
        // inOrderTravlot();
        // postOrderTraversal(root);
        // preOrderTraversal();
        // preOrderTraversal(root);
        // postOrderTraversal(root);
        // System.out.println(sumBinaryTree(root));

    }

}