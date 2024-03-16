import java.util.*;
import java.util.Arrays;

public class GreedyAlgo {

    public static void minPartionDenomination(int n) {
        int[] a = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] <= n) {
                while (a[i] <= n) {
                    ans.add(a[i]);
                    n -= a[i];
                }
            }
        }
        System.out.println(ans);
    }

    public static void findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int chain = 1;
        int last = pairs[0][1];
        for (int i = 0; i < pairs.length; i++) {
            if (last < pairs[i][0]) {
                chain++;
                last = pairs[i][1];

            }
        }
        System.out.println(chain);
    }

    public static void activitySelection(int[][] a) {
        Arrays.sort(a, Comparator.comparingDouble(o -> o[1]));
        int activities = 1;
        int end = a[0][1];
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] < end) {
                activities++;
                end = a[i][1];
            }
        }
        System.out.println(activities);
    }

    public static void minAbs(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        System.out.println(sum);
    }

    public static void jobSequence(int[] a, int[] b) {
        int[][] job = new int[a.length][2];
        int days = 0;
        for (int i = 0; i < a.length; i++) {
            job[i][0] = a[i];
            job[i][1] = b[i];
            days = Math.max(days, a[i]);
        }
        int[] d = new int[days];
        Arrays.sort(job, Comparator.comparingDouble(o -> o[1]));
        int profit = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            int ind = job[i][0] - 1;
            while (ind >= 0 && d[ind] == -1) {
                ind--;
            }
            if (ind >= 0 && d[ind] == 0) {
                d[ind] = -1;
                profit += job[i][1];
            }
        }
        System.out.println(profit);
    }

    public static void reverse(int[] a) {
        int left = 0;
        int right = a.length - 1;
        while (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    public static void mincostToCutBox(int[] v, int[] h, int m, int n) {
        Arrays.sort(v);
        Arrays.sort(h);
        reverse(v);
        reverse(h);
        int hc = 1;
        int vc = 1;
        int i = 0;
        int j = 0;
        int profit = 0;
        while (i < m && j < n) {
            if (v[i] >= h[j]) {
                profit += (v[i] * hc);
                vc++;
                i++;
            } else {
                profit += (h[j] * vc);
                hc++;
                j++;
            }
        }
        while (i < m) {
            profit += (v[i] * hc);
            vc++;
            i++;
        }
        while (j < n) {
            profit += (h[j] * vc);
            hc++;
            j++;
        }
        System.out.println(profit);
    }

    public static void fracKnapsack(int[] w, int[] p, int c) {
        int[][] a = new int[w.length][3];
        for (int i = 0; i < a.length; i++) {
            a[i][0] = w[i];
            a[i][1] = p[i];
            a[i][2] = p[i] / w[i];
        }
        int profit = 0;
        Arrays.sort(a, Comparator.comparingDouble(o -> o[2]));
        for (int i = a.length - 1; i >= 0; i--) {
            if (c >= a[i][0]) {
                profit += a[i][1];
                c -= a[i][0];
            } else {
                profit += (c * a[i][2]);
                break;
            }
        }
        System.out.println(profit);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        // int n=sc.nextInt();
        // minPartionDenomination(n);
        int[][] pairs = { { 2, 3 }, { 3, 4 }, { 4, 5 }, { 6, 7 } };
        // findLongestChain(pairs);
        // activitySelection(pairs);
        // int []deadlines={2,1,2,1,1};
        // int []profit={100,19,27,25,15};
        jobSequence(deadlines, profit);
        // minAbs(deadlines,profit);
        /*
         * int m=sc.nextInt();
         * int []v=new int[m];
         * for(int i=0;i<m;i++){
         * v[i]=sc.nextInt();
         * }
         * int n=sc.nextInt();
         * int []h=new int[n];
         * for(int i=0;i<n;i++){
         * h[i]=sc.nextInt();
         * }
         * mincostToCostBox(v,h,m,n);
         */
        int[] w = { 30, 60, 90 };
        int[] p = { 10, 20, 40 };
        int c = 120;
        fracKnapsack(w, p, c);
    }

}
