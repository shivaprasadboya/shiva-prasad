
// import java.util.Stack;
import java.util.*;

public class Stacks {

    public static boolean brackets(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char d = s.charAt(i);
            if (d == '{' | d == '(' || d == '[') {
                st.push(d);
            } else if (st.isEmpty()) {
                return false;
            } else {
                if (d == '}')
                    d = '{';
                else if (d == ']')
                    d = '[';
                else
                    d = '(';
                if (d != st.peek())
                    return false;
                else {
                    st.pop();
                }
            }
        }
        if (st.isEmpty())
            return true;
        else
            return false;
    }

    public static Stack<Integer> st = new Stack<>();

    // ---------push----------------//
    public static void push(int i) {
        st.push(i);
    }

    // -----------------pop---------------//
    public static void pop() {
        st.pop();
    }

    // -------------------size-------------------//
    public static void size() {
        System.out.println(st.size());
    }

    // ----------------checking empty or not --------------//
    public static boolean isEmpty() {
        if (!st.isEmpty())
            return true;
        else
            return false;

    }

    // ---------------finding peek element--------------------//
    public static int peek() {
        if (!st.isEmpty()) {
            return st.peek();
        } else
            return -1;

    }

    // ----------------next greater element-----------------------//
    public static void nextGreaterEle(int a[]) {
        int nge[] = new int[a.length];
        Stack<Integer> st = new Stack<>();
        for (int i = a.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[i] >= a[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nge[i] = -1;
            else
                nge[i] = a[st.peek()];
            st.push(i);

        }
        for (int i = 0; i < nge.length; i++) {
            System.out.print(nge[i] + " ");
        }

    }

    // ---------------Stock span---------------------//
    public static void stockSpan(int a[]) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            while (!st.isEmpty() && a[i] >= a[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                ans[i] = i + 1;
            else
                ans[i] = i - st.peek();
            st.push(i);

        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }
    // ------next Smaller element-------------------//

    public static void nextSmallerEle(int a[]) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[i] <= a[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = a[st.peek()];
            st.push(i);
        }
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }

    }

    // --------------next previous small element------------//
    public static void nextPreviousEle(int a[]) {
        Stack<Integer> st = new Stack<>();
        int nse[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            while (!st.isEmpty() && a[i] <= a[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nse[i] = -1;
            else
                nse[i] = a[st.peek()];
            st.push(i);
        }
        for (int i = 0; i < nse.length; i++) {
            System.out.print(nse[i] + " ");
        }
    }

    // -------------------Brackets (){}[]------------------//
    public static boolean brackets09(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char d = s.charAt(i);
            if (d == '{' | d == '(' || d == '[') {
                st.push(d);
            } else if (st.isEmpty()) {
                return false;
            } else {
                if (d == '}')
                    d = '{';
                else if (d == ']')
                    d = '[';
                else
                    d = '(';
                if (d != st.peek())
                    return false;
                else {
                    st.pop();
                }

            }
        }
        return false;

    }

    // ----------------maximum area---------------------//
    public static void rectangle1(int a[]) {
        Stack<Integer> st = new Stack<>();
        int nsR[] = new int[a.length];
        int nsL[] = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[i] <= a[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nsR[i] += a.length;
            else
                nsR[i] += st.peek();
            st.push(i);
        }
        for (int i = 0; i < a.length; i++) {
            while (!st.isEmpty() && a[i] <= a[st.peek()]) {
                st.pop();
            }
            if (st.isEmpty())
                nsL[i] += -1;
            else
                nsL[i] += st.peek();
            st.push(i);
        }
        int b = 0, max = 0;
        for (int i = 0; i < a.length; i++) {
            b = (nsR[i] - nsL[i] - 1) * a[i];
            max = Math.max(max, b);

        }
        System.out.println(max);

    }

    public static void maxArea(int a[]) {
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            int ans = 0;
            int ans2 = 0;
            int sol = 0;
            int lb = a[i];
            int rb = a[i];

            for (int j = i; j >= 0; j--) {
                if (lb <= a[j]) {
                    if (j == 0)
                        ans = j;
                    else
                        continue;
                } else {
                    ans = j + 1;
                    break;
                }
            }
            System.out.println(ans);
            for (int j = i; j < a.length; j++) {
                if (rb <= a[j]) {
                    if (j == 0)
                        ans2 = j + 1;
                    else
                        continue;
                } else {
                    ans2 = j + 1;
                    break;
                }
            }
            System.out.println(ans2);
            int res = Math.abs(ans * ans2) - 1;
            // System.out.println(res);
            sol = res * a[i];
            // System.out.println(sol);

            max = Math.max(max, sol);
            break;
        }
        System.out.println("---" + max);

    }

    public static void main(String[] args) {

        int a[] = { 4, 2, 1, 5, 6, 3, 2, 4, 2 };
        // nextSmallerEle(a);
        // nextPreviousEle(a);
        // nextGreaterEle(a);
        // stockSpan(a);
        maxArea(a);
        // push(10);
        // rectangle(a);
        // push(20);
        // System.out.println(st);
        // size();
        // pop();
        // System.out.println("----------------" + st.get(0));
        // System.out.println(isEmpty());
        // System.out.println(peek());
        // System.out.println(st);
        // rectangle(a);
        // String s = "{}()[]";
        // System.out.println(brackets(s));
        // brackets("shiva");
        // public static void rectangle(int a[]) {

        // }
        // -----------------------
        // ArrayList<Integer> al = new ArrayList<>();
        // int count = 0;
        // for (int i = a.length - 1; i >= 0; i--) {
        // int move = i;
        // count = 0;
        // while (move >= 0) {
        // if (a[move] > a[i]) {
        // al.add(count);
        // break;
        // }
        // move--;
        // count++;
        // }

        // }
        // al.add(1);
        // Collections.reverse(al);
        // System.out.println(al);
    }

}
