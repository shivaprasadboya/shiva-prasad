import java.util.*;

public class Recursion {
    // --------------sum of 1 to N-------------//
    public static void sum1toN(int start, int end, int sum) {
        if (start == end + 1) {
            System.out.println(sum);
            return;
        }
        sum1toN(start + 1, end, sum + start);

    }

    // ------------fibnaccii----------------------//
    public static int fibnacci(int n) {
        if (n <= 1)
            return n;
        return fibnacci(n - 1) + fibnacci(n - 2);
    }

    // ------------------factorial----------//
    public static void fact(int n, int fc) {
        if (n == 1 || n == 0) {
            System.out.println(fc);
            return;
        }
        fact(n - 1, fc * n);
    }

    // -------------multiplication n numbers-----//
    public static void mulNnumb(int n, int mul) {
        if (n == 0) {
            System.out.println(mul);
            return;
        }
        mulNnumb(n - 1, mul * n);
    }

    // -----print N natuural numbers----------//
    public static void printNnaturalNum(int n) {
        if (n == 0) {
            return;
        }
        printNnaturalNum(n - 1);
        System.out.println(n);
    }

    public static int factorial(int n, int fact) {
        if (n == 0) {
            return 1;
        }
        fact(n - 1, fact * n);
        return fact;
    }

    public static void fibonacci(int start, int end, int n) {
        if (n == 0)
            return;
        int c = start + end;
        System.out.print(c + " ");
        fibonacci(end, c, n - 1);
    }

    // -----------finding pow of a given number---------//
    public static void nPower(int n, int n2, int pow, int count) {
        if (pow == 0) {
            System.out.println(1);
            return;

        }
        if (count == pow) {
            System.out.println(n);
            return;
        }
        nPower(n * n2, n2, pow, count + 1);
    }

    // ----------x movs to end position-------------/
    public static void MoveXToEnd(String s, int i, String newStr, int count) {
        if (i == s.length()) {
            for (int j = 0; j < count; j++)
                newStr += "x";
            System.out.println(newStr);
            return;
        }
        if (s.charAt(i) == 'x')
            MoveXToEnd(s, i + 1, newStr, count + 1);
        else
            MoveXToEnd(s, i + 1, newStr + s.charAt(i), count);
    }

    // ------------first and llast occurence-----------/-/
    public static void FirstLastOccurance(String s, int i, char target, int first, int last) {
        if (i == s.length()) {
            System.out.println(first + " " + last);
            return;
        }
        if (s.charAt(i) == target) {

        }
    }

    // ----------remove duplicates---------------//
    public static boolean[] map = new boolean[26];

    public static void RemoveDuplicates(String s, int i, String newString) {
        if (i == s.length()) {
            System.out.println(newString);
            return;
        }
        if (map[s.charAt(i) - 97] == false) {
            map[s.charAt(i) - 97] = true;
            RemoveDuplicates(s, i + 1, newString + s.charAt(i));
        } else
            RemoveDuplicates(s, i + 1, newString);
    }

    // -----------print sub sequences-----------//
    public static void PrintSubSequences(String s, int i, String newStr) {
        if (i == s.length()) {
            System.out.print(newStr + " ");
            return;
        }
        PrintSubSequences(s, i + 1, newStr);
        PrintSubSequences(s, i + 1, newStr + s.charAt(i));
    }

    // ---------permutaations-----------//
    public static void PermutationsOnArray(int[] a, ArrayList<Integer> al, boolean[] b) {
        if (al.size() == a.length) {
            System.out.println(al);
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (b[i] == false) {
                b[i] = true;
                al.add(a[i]);
                PermutationsOnArray(a, al, b);
                al.remove(al.size() - 1);
                b[i] = false;
            }
        }
    }

    // --------towers of hanoi------------//
    public static void towersOfHanoi(int n, char src, char aux, char des) {
        if (n == 1) {
            System.out.println(src + "->" + des);
            return;
        }
        towersOfHanoi(n - 1, src, des, aux);
        towersOfHanoi(1, src, aux, des);
        towersOfHanoi(n - 1, aux, src, des);

    }

    // ----------reverse a string ------------//
    public static void reverseString(int n, String s) {
        if (n == 0) {
            System.out.println(s.charAt(n));
            return;
        }
        System.out.print(s.charAt(n));
        reverseString(n - 1, s);

    }

    public static void FirstLastOccurance(String s) {
        System.out.println(s.charAt(0));
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == s.charAt(0)) {
                System.out.println(i + " " + s.charAt(i));
            }
            // System.out.print(s.charAt(i) + " ");
        }

    }

    public static void printName1toN(String s, int n) {
        if (n == 0)
            return;
        printName1toN(s, n - 1);
        System.out.println(s);

    }

    public static void print1to5(int start, int end) {
        if (start == end + 1)
            return;
        System.out.println(start);
        print1to5(start + 1, end);
    }

    public static void print5to1(int start, int end) {
        if (start == end - 1)
            return;
        System.out.println(start);
        print5to1(start - 1, end);

    }

    public static void printNto1BackTrack(int start, int end) {
        if (end == start) {
            System.out.println(end);
            return;
        }
        print5to1(start, end + 1);
        System.out.println(end);

    }

    public static void sum1toNnum(int i, int sum) {
        // if (end == 0) {
        // System.out.println(sum);
        // return;
        // }
        // sum1toNnum(sum + end, end - 1);
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        sum1toNnum(i - 1, sum + i);

    }

    public static void print1to5BackTrack(int st, int ed) {
        // if (st == ed) {
        // System.out.println(st);
        // return;
        // }
        // print1to5BackTrack(st - 1, ed);
        // System.out.println(st);

    }

    public static int funSumRet(int n) {
        if (n == 0)
            return 1;
        return n * funSumRet(n - 1);
    }

    public static void reverseArray(int a[], int l, int n) {
        // if (l >= r) {
        // for (int i = 0; i < a.length; i++) {
        // System.out.print(a[i] + " ");
        // }
        // return;
        // }
        // int temp = a[l];
        // a[l] = a[r];
        // a[r] = temp;
        // reverseArray(a, l + 1, r - 1);

        if (l >= n / 2) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            return;
        }
        int temp = a[l];
        a[l] = a[n - l - 1];
        a[n - l - 1] = temp;
        reverseArray(a, l + 1, n);

    }

    // ------------string palindrome--------------//
    public static boolean stringPalindrome(char s[], int i) {
        if (s[i] != s[s.length - i - 1])
            return false;
        if (i >= s.length / 2)
            return true;
        return stringPalindrome(s, i + 1);
    }

    public static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void printSubSeq(String s, String ans) {
        if (s.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        printSubSeq(s.substring(1), ans + s.charAt(0));
        printSubSeq(s.substring(1), ans);
    }

    // ----------------prefix sum---------------//
    public static void prefixSum(int a[], int sum, int i) {
        if (i == a.length) {
            return;
        }
        System.out.print(sum + a[i] + " ");
        prefixSum(a, sum += a[i], ++i);

    }

    public static void main(String[] args) {
        // print1to10(1, 10);
        // towersOfHanoi(3, 'A', 'B', 'C');
        // fibnonacci(5);
        // print10to1(5);
        // printSubSeq("abc", "");
        // System.out.println(fib(4));
        int a[] = { 6, 3, -2, 4, -1, 0, -5 };
        prefixSum(a, 0, 0);
        // int st = 0;
        // int ed = a.length;
        // reverseArray(a, st, ed);
        // int b[] = { 212 };
        // int c = 1;
        // char s[] = { 'a', 'm', 'm', 'a' };
        // System.out.println(stringPalindrome(s, 0));

        // System.out.println(funSumRet(5));
        // print1to5(1, 5);
        // sum1toNnum(5, 0);
        // printNto1BackTrack(5, 1);
        // print1to5BackTrack(5, 1);
        // print5to1(5, 1);
        // printName1toN("shiva", 5);
        // // // print5to1(5, 1);

        // String s = "shivaprasad";
        // // int n = s.length();
        // FirstLastOccurance(s);
        // reverseString(s.length() - 1, s);
        // factorial(5, 1);
        // System.out.print(0 + " " + 1);
        // int start = 0;
        // String s = "shiva";
        // System.out.println(s.charAt(4));
        // int end = 1;
        // System.out.print(start + " " + end + " ");
        // fibonacci(start, end, 7 - 2);
        // print1to5(1, 5);
        // int n = 3;
        // int prev = n;
        // ----------------------------
        // int n = 100;
        // int n2 = n;
        // int pow = 1;
        // nPower(n, n2, pow, 1);
        // ------------------------------
        // towersOfHanoi();
        // sumNnumb(5, 1);
        // printNnaturalNum(10);
        // sum1toN(1, 5, 0);
        // sortString("shaiavivvjhjhcbsdbdkjcbckjnaas");
        // System.out.println(fibnacci(7));
        // fact(5, 1);

    }

}
