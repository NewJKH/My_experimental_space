package 알고리즘.B트리;

public class B_Tree {
    private static final int T = 3;
    private Node root = new Node();

    public static void main(String[] args) {
        B_Tree tree = new B_Tree();
        int[] data = {10, 20, 5, 6, 12, 30, 7, 17};

        for (int key : data) {
            tree.insert(key);
        }

        System.out.println("B-Tree 순회:");
        tree.traverse();

        System.out.println("검색 테스트:");
        System.out.println("12 찾음? " + tree.search(12));
        System.out.println("99 찾음? " + tree.search(99));
    }

    public void insert(int key) {
        Node r = root;
        if (r.n == 2*T - 1) {
            Node s = new Node();
            root = s;
            s.leaf = false;
            s.children[0] = r;
            splitChild(s, 0);
            insertNonFull(s, key);
        } else {
            insertNonFull(r, key);
        }
    }

    private void insertNonFull(Node x, int key) {
        int i = x.n - 1;
        if (x.leaf) {
            while (i >= 0 && key < x.keys[i]) {
                x.keys[i+1] = x.keys[i];
                i--;
            }
            x.keys[i+1] = key;
            x.n++;
        } else {
            while (i >= 0 && key < x.keys[i]) i--;
            i++;
            if (x.children[i].n == 2*T - 1) {
                splitChild(x, i);
                if (key > x.keys[i]) i++;
            }
            insertNonFull(x.children[i], key);
        }
    }

    private void splitChild(Node x, int i) {
        Node y = x.children[i];
        Node z = new Node();
        z.leaf = y.leaf;
        z.n = T - 1;

        for (int j = 0; j < T - 1; j++) {
            z.keys[j] = y.keys[j + T];
        }
        if (!y.leaf) {
            for (int j = 0; j < T; j++) {
                z.children[j] = y.children[j + T];
            }
        }
        y.n = T - 1;

        for (int j = x.n; j >= i + 1; j--) {
            x.children[j + 1] = x.children[j];
        }
        x.children[i + 1] = z;

        for (int j = x.n - 1; j >= i; j--) {
            x.keys[j + 1] = x.keys[j];
        }
        x.keys[i] = y.keys[T - 1];
        x.n++;
    }

    public void traverse() {
        if (root != null) root.traverse();
    }

    public boolean search(int key) {
        return root.search(key) != null;
    }

    static class Node {
        int n;
        int[] keys = new int[2*T - 1];
        Node[] children = new Node[2*T];
        boolean leaf = true;

        void traverse() {
            for (int i = 0; i < n; i++) {
                if (!leaf) children[i].traverse();
                System.out.print(keys[i] + " ");
            }
            if (!leaf) children[n].traverse();
        }

        Node search(int key) {
            int i = 0;
            while (i < n && key > keys[i]) i++;
            if (i < n && keys[i] == key) return this;
            if (leaf) return null;
            return children[i].search(key);
        }
    }
}
