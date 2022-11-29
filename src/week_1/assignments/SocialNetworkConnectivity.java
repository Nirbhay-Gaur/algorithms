package week_1.assignments;

public class SocialNetworkConnectivity {
    private final int[] connections = new int[10];
    private final int[] size = new int[10];

    private int maxSize = -1;

    public SocialNetworkConnectivity() {

        // initialize connections and size array
        for (int i = 0; i < 10; i++) {
            connections[i] = i;
            size[i] = 1;
        }
    }

    public static void main(String[] args) {
        SocialNetworkConnectivity socialNetworkConnectivity = new SocialNetworkConnectivity();
        socialNetworkConnectivity.connect(0, 1);
        socialNetworkConnectivity.connect(1, 2);
        socialNetworkConnectivity.connect(2, 3);
        socialNetworkConnectivity.connect(3, 4);
        socialNetworkConnectivity.connect(4, 5);
        socialNetworkConnectivity.connect(5, 6);
        socialNetworkConnectivity.connect(6, 7);
        socialNetworkConnectivity.connect(7, 8);
        socialNetworkConnectivity.connect(8, 9);
    }

    private int root(int x) {
        while (connections[x] != x) {
            connections[x] = connections[connections[x]];
            x = connections[x];
        }
        return x;
    }

    public void connect(int a, int b) {
        int rootA = root(a);
        int rootB = root(b);
        if (rootA == rootB) return;

        if (size[rootA] > size[rootB]) {
            connections[rootB] = rootA;
            size[rootA] += size[rootB];
            if (size[rootA] > maxSize) maxSize = size[rootA];
        } else {
            connections[rootA] = rootB;
            size[rootB] += size[rootA];
            if (size[rootB] > maxSize) maxSize = size[rootB];
        }

        System.out.println(a + "---" + b);

        if (maxSize == 10) {
            System.out.println("THIS IS THE EARLIEST TIME AT WHICH ALL MEMBERS ARE CONNECTED");
        }

    }

}