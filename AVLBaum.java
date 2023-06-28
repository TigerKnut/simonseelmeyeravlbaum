/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 06.02.2023
 * @author 
 */

public class AVLBaum {
  
  public static BinTree lRotation(BinTree bt){
    BinTree vaterNeu = bt.getRight(); // Es wird eine Referenz auf den rechten Teilbaum des übergebenen Baumes erstellt
    bt.setRight(vaterNeu.getLeft());  // Der linke Teilbaum vom rechten Teilbaum (= vaterNeu) wird als rechter Teilbaum des übergebenen Baumes gesetzt
    vaterNeu.setLeft(bt);             // Der (in Z.13) angepasste  übergebene Baum wird als linker Teilbaum des neuen Vaterknotens gesetzt
    return vaterNeu;                  // Rückgabe des linksrotierten Baumes
  }
  
  public static BinTree rRotation(BinTree bt){
    BinTree vaterNeu = bt.getLeft(); // Es wird eine Referenz auf den linken Teilbaum des übergebenen Baumes erstellt
    bt.setLeft(vaterNeu.getRight()); // Der rechte Teilbaum vom linken Teilbaum (= vaterNeu) wird als linker Teilbaum des übergebenen Baumes gesetzt
    vaterNeu.setRight(bt);           // Der (in Z.20) angepasste  übergebene Baum wird als rechter Teilbaum des neuen Vaterknotens gesetzt
    return vaterNeu;                 // Rückgabe des rechtsrotierten Baumes
  }
  
  public static BinTree rlRotation(BinTree bt){
    bt.setRight(rRotation(bt.getRight())); // Durchführung einer Rechtsrotation beim rechten Kind des übergebenen Baumes
    return lRotation(bt);                // nachdem der rechte Teilbaum rechtsrotiert wurde kann nun eine Linksrotation durchgeführt werden + Rückgabe des rl rotierten Baumes
  }
  
  public static BinTree lrRotation(BinTree bt){
    bt.setLeft(lRotation(bt.getLeft())); // Durchführung einer Linksrotation beim linken Kind des übergebenen Baumes
    return rRotation(bt);                // nachdem der linke Teilbaum linksrotiert wurde kann nun eine Rechtsrotation durchgeführt werden + Rückgabe des lr rotierten Baumes
  }
  
  public static BinTree avlbauml(){
    // Anlegen von Binaeren Teilbaeumen ohne Kanten
    
    BinTree bt5 = new BinTree(5);
    
    insert(3,bt5);
    insert(8,bt5);
    insert(7,bt5);
    insert(9,bt5);
    insert(10,bt5);
    
    System.out.println("Ausgabe inOrder:" + inOrder(bt5));
    System.out.println("Ausgabe preOrder:" + preOrder(bt5));
    
    bt5 = lRotation(bt5);
    
    System.out.println("Ausgabe inOrder nach Rotation:" + inOrder(bt5));
    System.out.println("Ausgabe preOrder nach Rotation:" + preOrder(bt5));
    
    return bt5;
  }
  
  public static BinTree avlbaumr() {
    // Anlegen von Binaeren Teilbaeumen ohne Kanten
    BinTree bt8 = new BinTree(8);
    
    insert(9, bt8);
    insert(6, bt8);
    insert(7, bt8);
    insert(5, bt8);
    insert(4, bt8);
    
    System.out.println("Ausgabe inOrder:" + inOrder(bt8));
    System.out.println("Ausgabe preOrder:" + preOrder(bt8));
    
    bt8 = rRotation(bt8);
    
    System.out.println("Ausgabe inOrder nach Rotation:" + inOrder(bt8));
    System.out.println("Ausgabe preOrder nach Rotation:" + preOrder(bt8));
    
    return bt8;
  }
  
  public static BinTree avlbaumlr() {
    
    BinTree bt10 = new BinTree(10);
    
    insert(12, bt10);
    insert(6, bt10);
    insert(5, bt10);
    insert(8, bt10);
    insert(7, bt10);
    
    System.out.println("Ausgabe inOrder:" + inOrder(bt10));
    System.out.println("Ausgabe preOrder:" + preOrder(bt10));
    
    bt10 = rRotation(bt10);
    
    System.out.println("Ausgabe inOrder nach Rotation:" + inOrder(bt10));
    System.out.println("Ausgabe preOrder nach Rotation:" + preOrder(bt10));
    
    return bt10;
  }
  
  public static void insert(int zahl , BinTree root){
    BinTree bt = new BinTree(zahl);
    if (zahl <  root.getItem()) {
      if (root.hasLeft()) {
        insert(zahl , root.getLeft());
      } else {
        root.setLeft(bt);
      } // end of if-else   
    } else {
      if (root.hasRight()) {
        insert(zahl , root.getRight());
      } else {
        root.setRight(bt);
      } // end of if-else   
    } // end of if-else
  }
  
  public static String preOrder(BinTree root) {
    
    String preOrder = "";
    
    preOrder += " " + root.getItem(); 
    
    if (root.hasLeft()) {
      preOrder += preOrder(root.getLeft());
    } // end of if
    
    if (root.hasRight()) {
      preOrder += preOrder(root.getRight());
    } // end of if
    
    
    return preOrder;
  }
    
  public static String postOrder(BinTree root) { 
    
    String postOrder = "";
    
    if (root.hasLeft()) {
      postOrder += postOrder(root.getLeft());
    } // end of if
    
    if (root.hasRight()) {
      postOrder += postOrder(root.getRight());
    } // end of if
    
    
    postOrder += " " + root.getItem();
    
    return postOrder;
  }  
    
  public static String inOrder(BinTree root) { 
    
    String inOrder = "";
    
    if (root.hasLeft()) {
      inOrder += inOrder(root.getLeft());
    } // end of if
    
    inOrder += " " + root.getItem();
    
    if (root.hasRight()) {
      inOrder += inOrder(root.getRight());
    } // end of if
    
    return inOrder;
  }
    
    
  
} // end of class AVLBaum
