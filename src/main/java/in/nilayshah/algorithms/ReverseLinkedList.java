package in.nilayshah.algorithms;

public class ReverseLinkedList{
  public void reverseLinkedList(){
    Node reversedPart = null;
    Node current = head;
    while (current != null) {
      Node next = current.next;
      current.next = reversedPart;
      reversedPart = current;
      current = next;
    }
    head = reversedPart;
  }
}

class Node{
   public int data;
   public Node next;
   public Node(int data, Node next){
      this.data = data;
      this.next = next;
   }
}
