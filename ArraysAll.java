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

    // public static void negativePrint(int a[]) {
    // for (int i = 0; i < a.length; i++) {
    // if (a[i] < 0)
    // System.out.print(a[i] + " ");
    // }

    // }

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

    public static int duplicateHash(int a[]) {
        // HashMap<Interger, Interger> map = new HashMap<>();
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

    // ---------------anagram comapring two equla length strings-------//
    public static void anagram2(String a, String b) {
        if (a.length() != b.length()) {
            System.out.println("not anagram");

        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);
        }
        System.out.println(map);
        int right = 0;
        int count = a.length();
        while (right < b.length()) {
            char c1 = b.charAt(right);
            // if (map.containsKey(c1)) {
            // count--;
            // }
            if (map.containsKey(c1) && map.get(c1) > 0) {
                map.put(c1, map.get(c1) - 1);
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

    public static ArrayList<Integer> findFirstNegative(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> window = new ArrayList<>();

        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (nums[right] < 0) {
                window.add(nums[right]);
            }

            if (right - left + 1 == k) {
                if (window.isEmpty()) {
                    result.add(0);
                } else {
                    result.add(window.get(0));
                    if (nums[left] == window.get(0)) {
                        window.remove(0);
                    }
                }
                left++;
            }

            right++;
        }

        return result;
    }

    // --------------Kth highest elemenrt in an array-----//
    public static int kthLargest(int a[], int k) {
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
                    // System.err.println(a[i]);
                    break;
                }
            }

        }
        return i + 1;

    }
    // -----------Buy and sell stocks O(n square)-------//

    public static void buyAndSellStocks(int a[]) {
        int max = 0;
        int ans = 0;
        for (int i = 0; i < a.length - 1; i++) {
            max = a[i];
            for (int j = i + 1; j < a.length; j++) {
                max = Math.max(a[j], max - a[i]);
            }
            ans = Math.max(max, ans);
        }
        System.out.println(ans);
    }

    public static void maxProfit(int[] a) {
        int l = a.length;

        int maxProfit = 0;
        int minPrice = a[0];
        for (int i = 1; i < l; i++) {
            maxProfit = Math.max(maxProfit, a[i] - minPrice);
            minPrice = Math.min(minPrice, a[i]);
        }

        System.out.println(maxProfit);
    }

    public static void lenFind(int a[], int sum) {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum1 = 0;
        int max = 0;
        while (right < a.length) {
            sum1 += a[right];
            count++;
            System.out.println(count);

            if (sum1 == sum) {
                max = Math.max(max, count);
                left++;
                right = left;
                sum1 = 0;
                count = 0;
            }
            // right++;
            if (sum1 > sum) {
                sum1 -= a[left];

                left++;

                count--;
            }
            right++;

        }
        System.out.println(max);
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

    public static int pairsRem(int a[]) {

        if (a.length <= 2)
            return a.length;

        // int index = 2;

        // // for (int i = 2; i < a.length; i++) {
        // // if (a[i] != a[index - 2]) {
        // // a[index] = a[i];
        // // index++;
        // // }
        // // }

        // return index;

        int left = 2;
        int right = 2;
        while (right < a.length) {
            if (a[right] != a[left - 2]) {
                a[left] = a[right];
                left++;
            }
            right++;
        }
        return left;

    }

    public static void reverse1(int a[], int start, int end) {
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }

    }

    public static void rotate1(int a[], int k) {
        k = k * -1;
        if (k < 0) {
            k = k + a.length;
        }
        k = k % a.length;
        reverse1(a, 0, k - 1);
        reverse1(a, k, a.length - 1);
        reverse1(a, 0, a.length - 1);
    }

    public static boolean stepsToReach(int a[]) {
        int i = 0;

        while (i < a.length) {
            if (a[i] < a.length && a[i] != 0) {
                i = a[i];
            }
            if (i == a.length - 1 || i > a.length || i == a.length)
                return true;

        }
        return false;

    }
    // ---------------------rain water trapping ------------------------//

    public static int rainTrapper(int a[]) {
        int res = 0;
        for (int i = 1; i < a.length; i++) {
            int lb = a[i];
            for (int j = 0; j < i; j++)
                if (a[j] > a[i])
                    lb = a[j];
            int rb = a[i];
            for (int j = i + 1; j < a.length; j++)
                if (a[j] > rb)
                    rb = a[j];
            int wl;
            if (rb > lb)
                wl = lb;
            else
                wl = rb;
            int tr = wl - a[i];
            res += tr;

        }
        return res;
    }

    // ----------Boyer Moore Algoriythm-------------//
    public static void booyerMooreVote(int a[]) {

        int votes = 0;
        int maj = -1;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (votes == 0) {
                maj = a[i];
                votes = 1;
            } else if (a[i] == maj) {
                votes++;
            } else {
                votes--;
            }

        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == maj) {
                count++;
            }
        }
        if (count > a.length / 2)
            System.out.println(maj);
    }
    // -----------max consecutive Range-----------------//

    public static void maxConsecutive(int a[]) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                count++;
            } else
                count = 0;
            max = Math.max(max, count);
        }
        System.out.println(max);

    }

    // -------Buy and sell Stocks---------------//
    public static void buyAndSellStocks2(int a[]) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int profit = 0;

        for (int i = 0; i < a.length; i++) {
            min = Math.min(min, a[i]);
            max = a[i] - min;
            profit = Math.max(profit, max);
        }
        System.out.println(profit);

    }
    // ----------Removing Duplicates in an Array--[Sorted ArrayOnly]------//

    public static int removingDuplicates(int a[]) {
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
        return d + 1;
        // for (int k = 0; k <= d; k++) {
        // System.out.print(a[k] + " ");
        // }
        // // return i;
    }

    // ---------------right rotate------------//
    public static void rightKthRotation(int a[], int k) {
        if (k < 0) {
            k = k + a.length;
        }
        k = k % a.length;
        for (int i = 0; i < k; i++) {
            int temp = a[a.length - 1];
            for (int j = a.length - 1; j > 0; j--) {
                a[j] = a[j - 1];
            }
            a[0] = temp;
        }
        printArray(a);
    }

    public static void negativePrint(int a[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.get(i) < 0) {
                map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            }
        }
        // System.out.println(map);
        printArray(a);

    }

    // -----------special count O(n square)----------//
    public static void specialCount(int a[]) {
        int even = 0;
        int odd = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            for (int j = i; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            for (int j = 0; j < a.length - 1; j++) {
                if (j % 2 == 0)
                    even += a[j];
                else
                    odd += a[j];
            }
            System.out.println(even + " " + odd);
            if (even == odd)
                count++;
            for (int j = a.length - 1; j > i; j--) {
                a[j] = a[j - 1];
            }
            a[i] = temp;
            odd = 0;
            even = 0;
        }

        System.out.println(count);

    }

    public static void prefix(int a[]) {
        Scanner sc = new Scanner(System.in);
        int pre[] = new int[a.length];
        pre[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            pre[i] = a[i] + pre[i - 1];
        }
        printArray(pre);
        int q = 4;
        int b[][] = new int[q][2];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < 2; j++) {
                b[i][j] = sc.nextInt();

            }
        }
        for (int i = 0; i < q; i++) {
            if (b[i][0] == 0)
                System.out.println(pre[b[i][1]]);
            else {
                System.out.println(pre[b[i][1]] - pre[b[i][0] - 1]);
            }
        }
    }

    // ---------------insertion sort--------------------//
    public static int[] insertionsort(int a[]) {

        int b = a.length;

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
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < b; i++) {
            al.add(a[i]);
        }
        return a;
    }

    // --------------Rotate k times-------------(algorithm)-------//
    public static void rotate(int a[], int k) {
        k = k * -1;
        if (k < 0) {
            k = k + a.length;
        }
        k = k % a.length;
        reverse(a, 0, k - 1);
        reverse(a, k, a.length - 1);
        reverse(a, 0, a.length - 1);
        printArray(a);

    }

    public static void reverse(int a[], int start, int end) {

        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
    // ------------Anagram-------------//

    public static int anagram(String pat, String txt) {

        // HashMap<Character, Integer> map = new HashMap<>();
        // for (int i = 0; i < pat.length(); i++) {
        // map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i), 0) + 1);

        // }
        // int count = map.size();
        // int ans = 0;
        // int left = 0;
        // int right = 0;
        // while (right < txt.length()) {
        // char c1 = txt.charAt(right);
        // if (map.containsKey(c1)) {
        // map.put(c1, map.get(c1) - 1);
        // if (map.get(c1) == 0) {
        // count--;
        // }

        // }
        // if (right - left + 1 == map.size()) {
        // if (count == 0)
        // ans++;
        // char c2 = txt.charAt(left);
        // if (map.containsKey(c2)) {
        // map.put(c2, map.get(c2) + 1);
        // if (map.get(c2) == 1)
        // count++;
        // }
        // left++;
        // }
        // right++;
        // }
        // return ans;
        // ----------------
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pat.length(); i++) {
            map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i), 0) + 1);
        }
        int count = map.size();
        int left = 0;
        int right = 0;
        int ans = 0;
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

    public static void kHighestEle(int a[], int k) {
        Arrays.sort(a);
        // System.out.println(a);
        printArray(a);
        int count = k;
        int right = a.length - 2;
        int left = a.length - 1;
        if (k == 1)
            System.out.println(a[a.length - 1]);
        while (right >= 0) {
            if (a[left] == a[right])
                right--;
            else if (a[right] != a[left]) {
                left = right;

                count--;
                if (count == 1) {
                    System.out.println(a[right]);
                    break;
                }

            }

        }

    }

    public static void countArea(int a[]) {
        int sum = 0;
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            int lb = a[i];
            for (int j = 0; j < i; j++) {
                if (a[j] > lb)
                    lb = a[j];

            }
            int rb = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] > rb)
                    rb = a[j];
            }
            sum = (lb + rb) / 2;
            System.out.println(lb + " " + rb);
            // sum = sum * 2;
            max = Math.max(max, sum);

        }
        System.out.println(max);

    }

    public static void oddCount(int a[]) {
        // int maj = -1;
        // int votes = 0;
        // int l = 0;
        // int r = 0;
        // int count = 0;
        // while (r < a.length) {
        // if (a[l] == a[r]) {
        // count++;
        // } else if (a[r] != a[l]) {
        // if (count % 2 != 0) {
        // System.out.println(a[r]);
        // count = 0;
        // }
        // l++;
        // }
        // r++;
        // }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) % 2 != 0) {
                System.out.println(i);
            }
        }
    }

    public static void nextGreater(int a[]) {
        Stack<Integer> st = new Stack<>();
        int next[] = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[i] >= a[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                // System.out.println("-1");
                next[i] = -1;
            else
                next[i] = a[st.peek()];
            st.push(i);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(next[i] + " ");
        }

    }

    public static void main(String[] args) {
        // // Scanner sc = new Scanner(System.in);s
        int a[] = { 6, 9, 2, 0, 8, 1, 3 };
        nextGreater(a);
        // countArea(a);
        // oddCount(a);
        // kHighestEle(a, 2);
        // eveodd(a)
        // oddCount(a);
        // rotate(a, 2);
        // // System.out.println(insertionsort(a));

        // lSumRsum(a);
        // String pat = "tgz";
        // sumBro(a);
        // prefix(a);

        // eveodd(a);
        // int even = 0;
        // int odd = 0;
        // // if (a.length % 2 == 0)
        // for (int i = 0, j = a.length - 1; i < a.length / 2 || j > (a.length / 2);
        // j--, i++) {
        // even += a[i];
        // odd += a[j];

        // }
        // if (a.length % 2 == 0)
        // odd -= a[a.length / 2];

        // System.out.println(even + " " + odd);
        // specialCount(a);
        // // negativePrint(a);
        // String txt = "tqzzrtgznrftg";
        // System.out.println(anagram(pat, txt));
        // rightKthRotation(a, 2);
        // maxConsecutive(a);
        // String pat = "abc";
        // String txt = "abcdacbac";
        // System.out.println(anagram(pat, txt));

        // buyAndSellStocks2(a);
        // System.out.println(removingDuplicates(a));
        // booyerMooreVote(a);
        // System.out.println(rainTrapper(a));

        // int[][] a = { { 0, 1 }, { 1, 4 }, { 2, 5 }, { 3, 6 } };
        // ]\TwoDprint(a);
        // // reverse(a, 0, 0);
        // // rotate(a,/ -3);
        // // buyAndSellStocks2(a);
        // stepsToReach(a);
        // System.out.println(RainTrapper(a));
        // int n = 33;
        // int ans = 100 - n;

        // if ((ans % 10) >= 5) {
        // ans = ans + (10 - (ans % 10));
        // } else {
        // ans = ans - (ans % 10);
        // }
        // System.out.println(ans);

        // printArray(a);

        // kHighestEle(a);
        // System.out.println(pairsRem(a));
        // printArray(a);

        // rightKthRotation(a, 2);
        // buyAndSellStocks(a);
        // lenFind(a, 12);
        // System.out.println(printRepeatValIndex(a, 2));
        // maxProfit(a);

        // slide(a);
        // lenFind(a, 5);
        // System.out.println(kthLargest(a, 2));

        // System.out.println(findFirstNegative(a, 3));
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
        // rearrangeArray(a, 5);

    }

    static void rearrangeArray(int arr[], int n) {

        Arrays.sort(arr);

        int[] temp = new int[n];

        int index = 0;

        for (int i = 0, j = n - 1; i <= n / 2 || j > n / 2; i++, j--) {
            if (index < n) {
                temp[index] = arr[i];
                index++;
            }

            if (index < n) {
                temp[index] = arr[j];
                index++;
            }
        }

        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
        printArray(temp);
    }

}