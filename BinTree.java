public class BinTree {
  //Attribute
  private Node root;
  
  //Konstruktoren
  public BinTree() {
    root = new Node (null,null);
  }
  
  public BinTree(int value) {
    root = new Node (null,value,null);
  }
  
  //normale Operationen/Methoden
  public Node getRoot() {
    return root;
  }
  
  public int getItem() {
    return root.getValue();
  }
  
  public void setValue(int value) {
    root.setValue(value);
  }
  
  public void deleteItem() {
    root.deleteValue();
  }
  
  public boolean isLeaf() {
    return !root.hasLeft() && !root.hasRight();
  }

  
  //Operationen Links
  public BinTree getLeft() {
    BinTree bt = new BinTree();
    bt.root = this.root.getLeft();
    return bt;
  }
  
  public boolean hasLeft(){
    return root.hasLeft();
  }
  
  public void setLeft(BinTree left) {
    root.setLeft(left.getRoot());
  }
  
  public void deleteLeft() {
    root.setLeft(null);
  }
  
  //Operationen Rechts
  public BinTree getRight() {
    BinTree bt = new BinTree();
    bt.root = this.root.getRight();
    return bt;
  }
    
  public boolean hasRight() {
    return root.hasRight();
  }
  
  public void setRight(BinTree right) {
    root.setRight(right.getRoot());
  }
  
  public void deleteRight() {
    setRight(null);
  }
  
  public int search(int value) {
    if (getItem() == value) {
      System.out.print(value);
      return value;
    } // end of if
  
    if (!this.hasLeft() && !this.hasRight()) {
      System.out.println("Kein Ergebnis");
      return 0;
    } 
    
    if (value < this.getItem()) {
      return getLeft().search(value);
    } else {
      return getRight().search(value);
    }
  }
}