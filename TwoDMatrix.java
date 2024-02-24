public class TwoDMatrix {

    public static void printAll(int a[][]) {

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();

        }
        System.out.println("--------------------");
    }

    // for (int i = a.length - 1; i >= 0; i--) {
    // for (int j = 0; j < a[i].length; j++) {

    // }
    // // System.out.println();

    // for (int k = a.length - 1; k >= 0; k--) {
    // System.out.print(a[i][k] + " ");
    // }
    // System.out.println();

    // }

    // cornerNumPrinting(a);
    // SpiralTraverse(a);

    // ------------Boundary elements printing in 2D Array---------------//

    public static void cornerNumPrinting(int a[][]) {

        System.out.println("-----------------------------");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[0][i] + " ");

        }
        System.out.println();
        for (int i = 1; i < a.length; i++) {
            System.out.print(a[i][a.length - 1] + " ");

        }
        System.out.println();
        for (int i = a.length - 2; i >= 0; i--) {
            System.out.print(a[a.length - 1][i] + " ");

        }
        System.out.println();
        for (int i = a.length - 2; i > 0; i--) {
            System.out.print(a[i][0] + " ");
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[0][i] + " ");
        }
        //
        printAll(a);

    }
    // ---------Spiral traverse in 2D Array--------------//

    public static void SpiralTraverse(int a[][]) {
        int top = 0;
        int bottom = a.length - 1;
        int left = 0;
        int right = a[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(a[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(a[i][right]);

            }
            right--;
            for (int i = right; i >= left; i--) {
                System.out.print(a[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                System.out.print(a[i][left]);

            }
            left++;

        }

    }

    // ---------transpsoe------//
    public static void transpose(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {

                // System.out.print(a[i][j] + " ");
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;

            }
            // System.out.println();
        }

        System.out.println("---------------");

    }

    // ----------Mirror Matrix--//
    public static void mirrormatrix(int a[][]) {
        transpose(a);
        for (int i = 0; i < a.length; i++) {
            int high = a.length - 1;
            int low = 0;
            while (low < high) {
                int temp = a[low][i];
                a[low][i] = a[high][i];
                a[high][i] = temp;
                low++;
                high--;
            }
        }
        int k = a.length - 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < a[i].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[k][j];
                a[k][j] = temp;
            }
            k--;

        }
        // for (int i = 0; i < a.length; i++) {
        // int left = 0;
        // int right = a.length - 1;
        // while (left < a.length) {
        // int temp = a[left][i];
        // a[left][i] = a[i][right];
        // a[i][right] = temp;

        // }

        // }

    }

    // ---------------right rotation----------------------------//
    static void rightRotate(int a[][]) {

        for (int i = 0; i < a.length; i++) {
            int low = 0;
            int high = a.length - 1;
            while (low < high) {
                int temp = a[i][low];
                a[i][low] = a[i][high];
                a[i][high] = temp;
                low++;
                high--;

            }

        }

    }
    // ---------left rotaion--------90 degrees-----//

    public static void leftRotate(int a[][]) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        for (int i = 0; i < a.length; i++) {

            int low = 0;
            int high = a.length - 1;
            while (low < high) {
                int temp = a[low][i];
                a[low][i] = a[high][i];
                a[high][i] = temp;
                low++;
                high--;
            }
        }

    }

    // --------snake patterns -----------//
    public static void snakePattern(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < a[i].length; j++) {

                    System.out.print(a[i][j] + " ");
                }
            } else {
                for (int j = a.length - 1; j >= 0; j--) {
                    System.out.print(a[i][j] + " ");
                }
            }

        }
    }

    public static void spiralTraverse0111(int a[][]) {
        int left = 0;
        int right = a[0].length - 1;
        int top = 0;
        int bottom = a.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                System.out.print(a[top][i] + " ");

            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(a[i][right] + " ");
            }
            right--;
            for (int i = right; i >= left; i--) {
                System.out.print(a[bottom][i] + " ");

            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                System.out.print(a[i][left] + " ");
            }
            left++;

        }

    }

    public static void tra(int a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {

                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;

            }
        }
        printAll(a);

    }

    public static void bor() {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1 || j == n || i == n)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void butter() {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // int n = a.length;
        // printAll(a);
        // // transpose(a);
        // tarac(a);
        // tra(a);
        // bor();
        butter();
        // // spiralTraverse0111(a);
        // snakePattern(a);
        // mirrormatrix(a);
        // printAll(a);
        // printAll(a);
        // // NdergreRotation(a);
        // // rightRotate(a, n);
        // // printAll(a);
        // leftRotate(a);
        // // rightRotate(a);
        // cornerNumPrinting(a);
        // printAll(a);
        // SpiralTraverse(a);

        // printAll(a);
    }

}