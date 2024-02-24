import java.util.Scanner;

//-----------patterns--------------//
public class Patterns {
    public static void venky() {
        int n = 5;
        int k = (2 * n) - 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j <= i || j >= (2 * n) - i) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= k; j++) {
                if (j <= i || j >= (2 * n) - i) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    // -----------------Butterfly-----------//

    public static void ButterFly(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");
            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }

    }

    public static void SandGlass(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");

            }

            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");

            }

            System.out.println();
        }

    }
    // ---------------------PascalTriangle-----------------//

    public static void PascalTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");

            }
            System.out.println();
        }
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");

            }
            System.out.println();
        }

    }

    // ---------Double Hill----------//
    public static void DoubleHill(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");

            }
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");

            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = 5;
        // ButterFly(5);
        // SandGlass(n);
        // PascalTriangle(n);
        venky();
        // DoubleHill(n);
    }
}
