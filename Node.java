public class Node {
  
  private Node left;
  private Integer value;
  private Node right;
  
  public Node (Node left, int value, Node right) {
    this.left = left;
    this.value = value;
    this.right = right;
  }
  
  public Node (Node left, Node right) {
    this.left = left;
    this.value = null;
    this.right = right;
  }
  
  public void setValue(int value) {
    this.value = value;
  }
  
  public int getValue() {
    if (this.hasValue()) {
      return value.intValue();
    }
    return 0;
  }
  
  public void deleteValue() {
    this.value = null;
  }
  
  public boolean hasValue() {
    if (value == null) {
      return false;
    } 
    return true;
  }
  
  public boolean hasLeft() {
     return this.left != null;
  }
  
  public Node getLeft() {
     return this.left;
  }
  
  public void setLeft(Node left) {
     this.left = left;
  }
  
  public boolean hasRight() {
     return this.right != null;
  }
  
  public Node getRight() {
     return this.right;
  }
  
  public void setRight(Node right) {
     this.right = right;
  }
  
}
