package LinkedList;

public class LinkedListRotate {


   static class ListNode{
        int data;
        ListNode next;
      }
    public static void main(String[] args){
        ListNode head = new ListNode();
        head.data = 0;
        head.next = new ListNode();
        head.next.data = 1;
        head.next.next = new ListNode();
        head.next.next.data = 2;
    
        head = rotateRight(head, 4);
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
}
    private static ListNode rotateRight(ListNode head, int i) {
        if(head == null || head.next == null || i == 0)
            return head;
        ListNode temp = head;
        int count = 0;
        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        temp.next = head;
        temp = head;
        for(int j = 0; j < count - i - 1; j++){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;

    }
}