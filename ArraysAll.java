import java.util.*;

public class ArraysAll {

    public static void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {

            System.out.print(a[i] + " ");
        }

        System.out.println();

    }

    // ---------------bubblesort-------------//
    public static void Bubblesort(int a[]) {
        int b = a.length;
        for (int i = 0; i < b; i++) {
            for (int j = i + 1; j < b - i; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;

                }

            }
        }
        System.out.println();
        printArray(a);
    }

    // ---------------insertion sort--------------------//
    public static int insertionsort(int a[]) {

        int b = a.length;
        // for (int i = 0; i < b; i++) {
        // System.out.print(" " + a[i]);
        // }
        System.out.println();
        for (int i = 1; i < b; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > temp) {

                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;

        }
        for (int i = 0; i < b; i++) {
            System.out.print(" " + a[i]);
        }
        return b;
    }

    // --------------------selection sort------------------//
    public static void Selectionsort(int a[]) {

        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;// searching for lowest index
                }
            }
            int smallerNumber = a[min];
            a[min] = a[i];
            a[i] = smallerNumber;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }

    }
    // ---------------------rain water trapping ------------------------//

    public static int RainTrapper(int a[]) {

        int b = a.length;
        int res = 0;

        for (int i = 1; i < b; i++) {
            int lb = a[i];
            for (int j = 0; j < i; j++) {
                if (a[j] > lb) {
                    lb = a[j];

                }

            }
            int rb = a[i];
            for (int j = i + 1; j < b; j++) {
                if (a[j] > rb) {
                    rb = a[j];
                }
            }

            int wl;
            if (rb > lb) {
                wl = lb;
            } else {
                wl = rb;
            }
            int tr = wl - a[i];
            res = res + tr;
        }
        return res;
    }

    // -------(more time complexity)-------------K th position rotation-----------//
    public static void leftKthRotation(int a[], int k) {
        int b = a.length;
        k = k % b;
        if (k < 0) {
            k = k + b;
        }
        for (int i = 0; i < k; i++) {
            int temp = a[0];
            for (int j = 0; j < b - 1; j++) {
                a[j] = a[j + 1];

            }
            a[b - 1] = temp;

        }
        for (int i = 0; i < b; i++) {

            System.out.print(" " + a[i]);
        }
    }

    // ------------Reverse of Array-------------------//

    // ----->***************************
    public static int[] ReverseArray(int a[]) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
        return a;
    }

    // -------------Printing Sub all SUB ARRAYS in java----------------//
    public static void subarrays(int a[]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(a[k] + " ");
                }
                System.out.println();
            }
        }

    }

    // -------------Kadan's Algorithm------------//
    public static void KadansAlgorithm(int a[]) {
        int cur_max = a[0];
        int max_sum = a[0];
        for (int i = 1; i < a.length; i++) {
            cur_max = Math.max(a[i], cur_max + a[i]);
            max_sum = Math.max(cur_max, max_sum);
        }
        System.out.println(max_sum);

    }

    // ------------------Dutch national flag--------------//
    static void dutchNationalFlag(int a[]) {
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        while (mid <= high) {
            if (a[mid] == 0) {
                int temp = a[mid];
                a[mid] = a[low];
                a[low] = temp;
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else if (a[mid] == 2) {
                int temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
            }
        }
        printArray(a);

    }

    // -------------------Moving zeoes at last in the Array------(DSA)------//
    public static void movingZeroesLast(int a[]) {

        int r = 0;
        int l = 0;
        while (r < a.length) {
            if (a[r] != 0) {
                int temp = a[r];
                a[r] = a[l];
                a[l] = temp;
                l++;

            }
            r++;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }

    }

    // ------------------Mid elemenet find in slow fast pointer-----------//
    public static void midElementFind(int a[]) {
        int slow = 0;
        int fast = 0;
        while (fast != a.length && fast != a.length) {
            slow += 1;
            fast += 2;

        }
        System.out.println(a[slow]);
        // int count = 0;
        // for (int i = 0; i < a.length; i++) {
        // count++;
        // }
        // int target = count / 2;
        // System.out.println(target);

    }

    public static int[] try1(int a[], int target) {

        for (int i = 0; i < a.length; i++) {

            if (a[i] >= target) {
                return new int[] { i };

            }
        }
        return new int[] { -1 };

    }

    public static int[] printRepeatValIndex(int a[], int target) {
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {

                return new int[] { i };
            }
        }
        return a;
    }

    public static int xyz(int nums[]) {

        int maj = -1;
        int votes = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (votes == 0) {
                maj = nums[i];
                votes = 1;
            } else if (maj != nums[i]) {
                votes--;
            } else {
                votes++;

            }
        }
        for (int i = 0; i < nums.length; i++) {

            if (maj == nums[i]) {
                count++;
            }

        }
        if (count > nums.length / 2) {
            return maj;
        }

        return -1;
    }

    public static void AliceBob(int a[], int n) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("enyeh t value:");
        // int t = 4;;
        // for (int l = 0; l < t; l++) {
        // int n = sc.nextInt();
        // int a[] = new int[n];
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[j] - a[i] == a[k] - a[j])
                        System.out.println("no");
                    else
                        System.out.println("yes");
                }
            }
        }

    }

    public static void arraySum(int a[]) {
        int low = 0;
        int sum = 0;

        int high = a.length - 1;
        while (low <= high) {
            sum += a[low] + a[high];
            low++;
            high--;

        }
        if ((a.length & 1) == 1)
            System.out.println(sum - a[a.length / 2]);
        else
            System.out.println(sum);

    }

    // public static void minel(int a[]) {
    // // printArray(Arrays.sort(a));
    // for()

    // }
    public static int slowfast(int a[]) {
        int slow = 0;
        int fast = 0;
        while (fast < a.length) {
            slow++;
            fast = fast + 2;
        }
        return slow;

    }

    // public static void minLastDigit(int a[]) {
    // int res = 9;
    // for (int i = 0; i < a.length; i++) {
    // int sum = a[i] % 10;
    // if (sum == 0) {
    // System.out.println(a[i] + " is min");
    // break;
    // }

    // else {
    // res = Math.min(res, sum);
    // i++;
    // }

    // }
    // System.out.println();
    // }

    public static void threeK(int a[]) {
        int left = 0;
        int sum = 0;
        int max1 = 0;
        for (int i = left; i < a.length - 3; i++) {
            for (int j = i; j < i + 3; j++) {
                sum += a[i];
            }
            max1 = Math.max(max1, sum);
        }
        System.out.println(max1);

    }

    // ----------Boyer Moore Algoriythm-------------//
    public static void booyerMooreVote(int a[]) {
        int votes = 0;
        int maj = -1;
        for (int i = 0; i < a.length; i++) {
            if (votes == 0) {
                maj = a[i];
                votes = 1;
            } else if (maj != a[i])
                votes--;
            else
                votes++;
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == maj)
                count++;
        }
        if (count > a.length / 2)
            System.out.println(maj);
    }

    public static void primeOrNot(int a[]) {
        int n = 113;
        int count = 0;
        for (int i = 2; i <= Math.sqrt(n / 2); i++) {
            if (n % i == 0)
                count++;
        }
        if (count == 0)
            System.out.println("prime");
        else
            System.out.println("not prime");

    }

    public static void kHighestEle(int a[]) {
        int count = 0;
        int i = a.length - 2;
        int j = a.length - 1;
        while (i >= 0) {
            if (count == 0) {
                System.out.println(a[j]);
                break;
            } else if (a[j] - a[i] == 0) {
                i--;
                j--;
            } else if (a[j] != a[i]) {
                count--;
                i--;
                j--;

            }

        }

    }

    public static void kthLargest(int a[], int k) {
        Arrays.sort(a);
        int count = k;
        int i = a.length - 2;
        int j = a.length - 1;
        if (k == 0 || k == 1) {
            System.out.println(a[a.length - 1]);
        }
        while (i >= 0) {
            if (a[i] == a[j]) {
                i -= 1;
            } else if (a[i] != a[j]) {
                count -= 1;
                j = i;
                if (count == 1) {
                    System.err.println(a[i]);
                    break;
                }
            }
        }
    }

    public static void z(int a[]) {

        Scanner s = new Scanner(System.in);
        int max = 0;
        int max2 = 0;
        int n = 9;
        System.out.println("please enter the nth max value");
        int k = s.nextInt();

        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        for (int j = 0; j < k - 1; j++) {

            for (int i = 0; i < n; i++) {
                if (a[i] > max2 && a[i] < max) {
                    max2 = a[i];

                }

            }

            max = max2;
            max2 = 0;
        }
        System.out.println(max);

    }

    // public static void k(int a[]) {
    // int a1[] = { 2, 3, 7, 9, 60 };
    // int b[] = { 0, 0, 0, 0, 0 };
    // int n = 5;
    // int mm = 1000;
    // for (int h = 0; h < n; h++) {
    // int max = 0;

    // for (int i = 0; i < n; i++) {
    // if (a1[i] / 10 == 0) {
    // if (a1[i] > max && max < mm)
    // max = a1[i];
    // } else if (a1[i] / 10 != 0) {
    // if (a1[i] / 10 > max && max < mm) {
    // max = a1[i];
    // }
    // }
    // }
    // b[h] = max;
    // mm = max;

    // }
    // for (int i = 0; i < n; i++) {
    // System.out.print(b[i] + " ");
    // }
    // }
    // --------------Rotate k times-------------(algorithm)-------//

    public static void reverse(int a[], int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }

    }

    public static void rotate(int a[], int k) {

        if (k < 0) {
            k = k + a.length;
        }
        k = k % a.length;
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
        reverse(a, 0, a.length - 1);
        printArray(a);

    }

    public static void rightKthRotation(int a[], int k) {
        int b = a.length;
        k = k % b;
        if (k < 0) {
            k = k + b;
        }
        for (int i = 0; i < k; i++) {
            int temp = a[a.length - 1];
            for (int j = a.length - 1; j >= 0; j--) {
                a[j] = a[j - 1];

            }
            a[0] = temp;

        }
        for (int i = 0; i < b; i++) {

            System.out.print(" " + a[i]);
        }
    }

    public static void negativePrint(int a[]) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0)
                System.out.print(a[i] + " ");
        }

    }

    public static void slideNegativePrint(int a[], int k) {
        int left = 0;
        int right = k;
        while (right < a.length) {

        }
    }

    public static void slideMaxK_Nums(int a[], int k) {
        // int sum = 0;
        // int left = 0;
        // int max = 0;
        // for (int i = left; i < k; i++) {
        // sum += a[i];
        // }
        // max = Math.max(max, sum);
        // while (k < a.length) {
        // sum += a[k];
        // sum -= a[left];
        // left++;
        // k++;
        // max = Math.max(max, sum);
        // }
        // System.out.println(max);
        int sum = 0;
        int left = 0;
        // int right = k;
        int max = 0;
        for (int i = left; i < k; i++) {
            sum += a[i];
        }
        max = Math.max(max, sum);
        while (k < a.length) {
            sum += a[k];
            sum -= a[left];
            k++;
            left++;

            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    public static void negToPos(int a[]) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0)
                a[i] = a[i] * -1;
        }
        printArray(a);

    }

    public static void maxRange(int a[]) {
        int max = 0;
        int rem = 0;
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] / 10 != 0) {
                rem = a[i] / 10;
                max = Math.max(max, rem);
            } else if (a[i] / 10 == 0) {
                max = Math.max(max, a[i]);
            }

        }
        System.out.println(max);

    }

    public static void consecutiveCount(int a[]) {
        int maj = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (count == 0) {
                maj = a[i];
                count = 1;
            } else if (maj != a[i]) {
                count = 0;
            } else if (maj == a[i]) {
                count++;
            }
            max = Math.max(max, count);
        }
        System.out.println(max);

    }
    // -----------max consecutive Range-----------------//

    public static void maxConsecutive(int a[]) {
        int count = 0;
        int max = 1;
        int maj = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                count += 1;

            } else if (maj != a[i]) {
                count = 0;
            } else if (a[i] == 0) {
                count += 1;

            }
            max = Math.max(max, count);
        }

        System.out.println(max);

    }

    public static void slide(int a[]) {
        int left = 0;
        int max = 0;
        int k = 3;
        int sum = 0;
        // for (int i = left; i < k; i++) {
        // sum += a[i];
        // }
        sum = a[0] + a[1] + a[2];
        max = Math.max(max, sum);
        while (k < a.length) {
            sum += a[k];
            sum -= a[left];
            left++;
            k++;
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
    // ----------Removing Duplicates in an Array--[Sorted ArrayOnly]------//

    public static void removingDuplicates(int a[]) {
        // Arrays.sort(a);
        // int d = 0;
        // int i = 1;
        // while (i < a.length) {
        // if (a[d] != a[i]) {
        // d++;
        // a[d] = a[i];
        // }
        // i++;
        // }
        // for (int k = 0; k <= d; k++) {
        // System.out.print(" " + a[k]);
        // }
        Arrays.sort(a);
        int d = 0;
        int i = 1;
        while (i < a.length) {
            if (a[d] != a[i]) {
                d++;
                a[d] = a[i];
            }
            i++;
        }
        for (int k = 0; k <= d; k++) {
            System.out.print(a[k] + " ");
        }
        // return i;

    }

    public static int duplicateHash(int a[]) {
        HashMap<Interger, Interger> map = new HashMap<>();
        int d = 0;
        int i = 1;
        while (i < a.length) {
            if (a[d] != a[i]) {
                d++;
                a[d] = a[i];
            }
            i++;
        }
        return d + 1;

    }

    public static int anagram(String pat, String txt) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pat.length(); i++) {
            map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i), 0) + 1);
        }
        int count = pat.length();
        int ans = 0;
        int left = 0;
        int right = 0;
        while (right < txt.length()) {
            char c1 = txt.charAt(right);
            if (map.containsKey(c1)) {
                map.put(c1, map.get(c1) - 1);
                if (map.get(c1) == 0)
                    count--;
            }
            if (right - left + 1 == map.size()) {
                if (count == 0)
                    ans++;
                char c2 = txt.charAt(left);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) == 1)
                        count++;
                }
                left++;
            }
            right++;
        }
        return ans;

    }

    public static void anagram2(String a, String b) {
        if (a.length() != b.length()) {
            System.out.println("not anagram");

        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }
        // System.out.println(map);
        int right = 0;
        int count = a.length();
        while (right < b.length()) {
            char c1 = b.charAt(right);
            if (map.containsKey(c1)) {
                count--;
            }
            right++;
        }
        if (count == 0) {
            System.out.println("Anagram");
        } else {
            System.out.println("no");
        }

    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);s
        int a[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        // rightKthRotation(a, 2);
        // slide(a);
        String pat = "cat";
        String txt = "aca";
        anagram2(pat, txt);
        // System.out.println(anagram(pat, txt));
        // System.out.println(duplicateHash(a));
        // removingDuplicates(a);
        // leftKthRotation(a, 2);
        // maxConsecutive(a);
        // consecutiveCount(a);
        // kad(a);
        // negToPos(a);
        // maxRange(a);
        // negativePrint(a);
        // maxRange(a);
        // rotate(a, -3);
        // Scanner sc = new Scanner(System.in);
        // z(a);
        // k(a);
        // kthLargest(a, 4);
        // slideMaxK_Nums(a, 3);
        // threeK(a);
        // minLastDigit(a);s
        // slideMax3NUms(a);
        // prac(a);

        // printArray();

        // int n = a.length;
        // AliceBob(a, n);
        // int k = 2;
        // printArray(a)
        // System.out.println(slowfast(a));
        // kd(a);
        // kad(a);
        // movingZeroesLast(a);
        // arraySum(
        // rotate(a, 2);
        // System.out.println();
        // removingDuplicates(a);
        // System.out.println(booyerMooreVote(a));
        // System.out.println(booyerMooreVote(a));
        // rotate(a, -1);
        // findIndex(a, 3);
        // booyerMooreVote(a);
        // DutchNationalFlag(a);
        // printRepeatValIndex(a, 2);
        // printArray(a);
        // System.out.println(printArray(a));
        // try1(a, 3);
        // printArray(a);
        // insertionsort(a);
        // kRotation(a, k);
        // Selectionsort(a);
        // Bubblesort(a);
        // midElementFind(a);
        // RainTrapper(a);
        // KthRotation(a, 4);
        // ReverseArray(a);
        // Subarrays(a);
        // KadansAlgorithm(a);
        // int arr_size = a.length;
        // DutchNationalFlag(a);
        // MovingZeroesLast(a);
        // RemovingDuplicates(a);
        // maxConsecutive(a);
        // System.out.println(RainTrapper(a));
        // KadansAlgorithm(a);
        // KadansAlgorithm(a);
        // subarrays(a);
        // dutchNationalFlag(a);

    }
}