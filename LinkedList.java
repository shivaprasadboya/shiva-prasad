import java.util.*;

public class LinkedList {

    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node head;

    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void countNodes() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println(count);
    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void deleteFirst() {
        head = head.next;
    }

    public static void deleteLast() {
        Node temp = head;
        while (temp.next.next.next != null) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp.next.next = null;
    }

    public static boolean search(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static void addAtGivenPos(int data, int target) {
        if (target < 0) {
            System.out.println("the given target is below 0");
            return;
        }
        if (target == 0) {
            addFirst(data);
        } else {
            int count = 0;
            Node temp = head;
            while (count != target - 1) {
                count++;
                temp = temp.next;
            }
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }

    }

    public static void deleteAtGivenPos(int target) {
        if (target < 0) {
            System.out.println("the given target is below 0");
            return;
        }
        if (target == 0) {
            deleteFirst();
            return;
        }
        int count = 0;
        Node temp = head;
        while (count != target - 1) {
            count++;
            temp = temp.next;
        }
        temp.next = temp.next.next;

    }

    public static void delMiddle() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int target = count / 2;
        deleteAtGivenPos(target);
        // int c = 0;
        // Node ele = head;
        // while (c != target - 1) {
        // c++;
        // ele = ele.next;
        // }
        // ele.next = ele.next.next;

    }

    // public static Node deleteMiddle(Node head) {
    // Node temp = head;
    // Node slow = head;
    // Node fast = head;
    // while (fast.next != null && fast.next.next != null) {
    // // slow = slow.next;
    // fast = fast.next.next;
    // slow = slow.next;
    // temp = temp.next;
    // }
    // temp.next = temp.next.next;
    // return head;
    //     }
    // -------------OddEvenSegregation---------------//

    public static Node oddEvenSegregation() {
        // if (head == null) {
        // System.out.println(head);
        // }
        // Node evenHead = new Node(-1);
        // Node oddHead = new Node(-1);
        // Node even = evenHead;
        // Node odd = oddHead;
        // Node temp = head;
        // int index = 0;
        // while (temp != null) {
        // if (index % 2 == 0) {
        // even.next = temp;
        // even = even.next;
        // } else {
        // odd.next = temp;
        // odd = odd.next;
        // }
        // index++;
        // temp = temp.next;
        // }

        // odd.next = null;
        // even.next = oddHead.next;
        // return evenHead.next;
        Node oddHead = new Node(-1);
        Node evenHead = new Node(-1);
        Node odd = oddHead;
        Node even = evenHead;
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if ((index & 1) == 0) {
                even.next = temp;
                even = even.next;
            } else {
                odd.next = temp;
                odd = odd.next;
            }
            index++;
            temp = temp.next;
        }
        odd.next = null;
        even.next = oddHead.next;
        return evenHead.next;

    }

    public static Node Sort() {
        Node zerohead = new Node(-1);
        Node onehead = new Node(-1);
        Node twohead = new Node(-1);
        Node zero = zerohead;
        Node one = onehead;
        Node two = twohead;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        two.next = null;
        if (onehead.next == null) {
            zero.next = twohead.next;
        } else {
            zero.next = onehead.next;
        }
        one.next = twohead.next;
        return zerohead.next;
    }

    // public static void palindrome() {
    // // Node newNode = new Node(0);
    // Node slow = head;
    // Node fast = head;
    // while (fast.next != null && fast.next.next != null) {
    // slow = slow.next;
    // fast = fast.next.next;
    // }
    // Node prev = null;

    // }

    public static boolean reverseNodes() {

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node cur = slow;
        Node prev = null;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        Node temp = head;
        while (temp != null && prev != null) {
            if (temp.data != prev.data)
                return false;
            prev = prev.next;
            temp = temp.next;
        }
        return true;

    }

    public static boolean palindromeOrNot() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node cur = slow;
        Node prev = null;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        Node temp = head;
        while (temp != null && prev != null) {
            if (temp.data != prev.data)
                return false;
            temp = temp.next;
            prev = prev.next;
        }
        return true;

    }

    public static Node rotationKtimes(int k) {
        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        count++;
        if (count % k == 0)
            return head;
        k = k % count;
        temp.next = head;
        Node prev = null;
        for (int i = 0; i < count - k; k++) {
            prev = temp;
            temp = temp.next;

        }
        prev.next = null;
        head = temp;
        return head;

    }

    public static Node kRotation(int k) {
        Node temp = head;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        count++;
        if (k % count == 0)
            return head;
        // else if (k < 0)
        // k = k + count;
        k = k % count;
        temp.next = head;
        Node prev = null;
        for (int i = 0; i < count - k; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        head = temp;

        return head;
    }

    // public static Node rightRotate(int k) {
    // Node temp = head;
    // int count = 0;
    // while (temp.next != null) {
    // count++;
    // temp = temp.next;
    // }
    // count++;
    // if (count % k == 0)
    // return head;
    // k = k % count;
    // Node prev = null;
    // temp.next = head;
    // for (int i = 0; i < count - k; k++) {
    // prev = temp;
    // temp = temp.next;
    // }

    // }
    public static Node head2;

    public static void printLL2() {
        Node temp = head2;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void intersectionPoint() {
        Node temp1 = head;
        Node temp2 = head2;

    }

    public static void removingLoop() {
        // Node temp = head;
        // Node prev = null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            // prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        Node cur = head;
        Node temp = slow;
        Node pre = null;
        while (temp != cur) {
            pre = temp;
            temp = temp.next;
            cur = cur.next;

        }
        pre.next = null;

    }

    public static Node removeLoop_2(Node head) {
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast)
            return head;
        slow = head;
        if (slow == fast) {
            prev.next = null;
            return head;
        }
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;
        return head;
    }

    // public static Node sumOfTwonodes() {
    // Node dummyNode = new Node(0);
    // Node cur = dummyNode;
    // Node temp1 = head;
    // Node temp2 = head2;
    // int carry = 0;
    // while (temp1 != null || temp2 != null) {
    // int sum = 0;
    // if (temp1 != null) {
    // sum += temp1.data;
    // temp1 = temp1.next;
    // }
    // if (temp2 != null) {
    // sum += temp2.data;
    // temp2 = temp2.next;
    // }
    // sum += carry;
    // carry = sum / 10;
    // Node newNode = new Node(sum % 10);

    // cur.next = newNode;
    // cur = cur.next;

    // }
    // Node newNode = new Node(carry);
    // if (carry != 0)

    // return cur.next;

    // }

    public static void midAdd(int data) {
        Node newNode = new Node(data);
        Node fast = head;
        Node slow = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        prev = newNode.next;
        newNode.next = slow;
        // newNode.next = slow.next;
        // slow.next = newNode;
    }

    public static Node addTwoLL() {
        Node newHead = new Node(-1);
        Node temp1 = head;
        Node temp2 = head2;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            int sum = 0;
            if (temp1 != null) {
                sum += temp1.data;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                sum += temp2.data;
                temp2 = temp2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node newNode = new Node(sum % 10);
            newHead.next = newNode;
            newHead = newNode;

        }
        Node newNode = new Node(carry);
        if (carry != 0) {
            newHead.next = newNode;

        }
        return newHead.next;

    }

    public static void startNode(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void endNode(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

    }

    public static Node delFirst() {
        if (head == null)
            return head;
        head = head.next;
        return head;
    }

    public static void delLast() {
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;

    }

    public static void addFir(int data, int target) {
        // if (target < 0)
        // System.out.println("linked list cannot form");
        // else if (target == 0)
        // addFirst(data);
        // else {
        Node newNode = new Node(data);
        Node temp = head;
        int count = 0;
        while (count != target - 1) {
            temp = temp.next;
            count++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        // }
    }

    public static Node findLoopElements() {
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;

            fast = fast.next;
            if (slow == fast) {
                slow = head;
                prev = slow;
                while (slow != fast) {

                    slow = slow.next;
                    fast = fast.next;
                }
                prev.next = null;

                return slow;
            }
        }
        return null;

    }

    public static void delLastAtSpec1(int target) {
        Node temp = head;
        int count = 0;
        Node c = head;
        while (count != target - 1) {
            temp = temp.next;
            count++;
            c = c.next;
        }
        c.next = temp.next = temp.next.next;

    }

    public static void main(String[] shiva) {
        Scanner sc = new Scanner(System.in);
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        // head.next.next.next = head.next;
        // startNode(10);
        // findLoopElements();
        // delLast();
        // delLastAtSpec1(2);
        // printLL();
        // // addFir(11, 2);
        // // delFirst();

        // // endNode(90);
        // printLL();
        // // oddEvenSegregation();
        // printLL();
        // head.next.next.next.next = new Node(50);
        // midAdd(99);
        // printLL();
        // head2 = new Node(1);
        // head2.next = new Node(2);
        // head2.next.next = new Node(3);
        // head2.next.next.next = new Node(4);
        // System.out.println(addTwoLL());
        // System.out.println();
        // System.out.println(sumOfTwonodes());
        // head.next.next.next.next = new Node(50);
        // head.next.next.next.next.next = head.next.next;
        // removingLoop();

        // removeLoop_2(head);
        // printLL();
        // head2.next = new Node(2);
        // head2.next.next = head.next.next;
        // printLL2()
        // int a = 10;
        // int b = 10;
        // System.out.println(a + b);
        // rotationKtimes(2);
        // kRotation(2);
        // printLL();
        // System.out.println(head);
        // head.next.next.next.next.next = new Node(0);
        // head.next.next.next.next.next.next = new Node(2);
        // System.out.println(reverseNodes());
        // System.out.println(palindrome());
        // head.next.next.next = new Node(40);
        // head.next.next.next.next = new Node(50);
        // printLL();
        // oddEvenSegregation();
        // printLL(head);
        // oddEvenSegregation();
        // // Sort();
        // // printLL();
        // i

        // }

        // addFirst(100);
        // // // addLast(100);
        // // printLL();
        // // // System.out.println(head.data);
        // deleteLast();
        // printLL();
        // printLL();
        // System.out.println(search(20));
        // addAtGivenPos(70, 2);
        // delMiddle();
        // search(90);

        // printLL();
    }
}
