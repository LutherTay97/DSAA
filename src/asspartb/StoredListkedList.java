/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asspartb;

/**
 *
 * @author A555LD
 */


import java.io.Serializable;

/**
 *
 * @author Win-8
 */
public class StoredListkedList<T extends Comparable<? super T>> implements StoredListInterface<T>, Serializable{
    private Node firstNode;
    private int length;
    
    public StoredListkedList(){
        firstNode = null;
        length = 0;
    }
    public boolean add(T newEntry) 
    {
        //Process
        Node newNode = new Node(newEntry);

        Node nodeBefore = null;
        
        Node currentNode = firstNode;				
        
        //Compare the data greater than 0 while it is currentNode not null
        while (currentNode != null && newEntry.compareTo((T)currentNode.data) > 0) 
        {
            nodeBefore = currentNode;
            
            currentNode = currentNode.next;
        }

        if (isEmpty() == true || nodeBefore == null) 
        { 
            newNode.next = firstNode;
            
            firstNode = newNode;
        } 
        else 
        {	
            newNode.next = currentNode;
            
            nodeBefore.next = newNode;
        }
        
        length++;
        
        //Output
        //Return Output
        return true;
    }
    
    
    private class Node implements Serializable{

    private T data;
    private Node next;

    private Node(T dataPortion) {
      data = dataPortion;
      next = null;
    }

    private Node(T dataPortion, Node nextNode) {
      data = dataPortion;
      next = nextNode;
    }
  }
    
    
    public boolean isEmpty() {
    boolean isEmpty = false;
    if(length == 0 && firstNode == null)
    {
        isEmpty = true;
    }
    return isEmpty;
  }
    
   public int getLength() {
    return length;
  }
   
    public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      result = currentNode.data;	// currentNode is pointing to the node at givenPosition
    }
    return result;
  }
    
      public boolean replace(int givenPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((givenPosition >= 1) && (givenPosition <= length)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        // System.out.println("Trace| currentNode.data = " + currentNode.data + "\t, i = " + i);
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      currentNode.data = newEntry;	// currentNode is pointing to the node at givenPosition
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }
    
    
 public boolean contains(T anEntry) {    
    
    boolean found = false;
    Node tempNode = firstNode;
    int pos = 1;

    while (!found && (tempNode != null)) {
      if (anEntry.compareTo(tempNode.data) <= 0) {
        found = true;
      } else {
        tempNode = tempNode.next;
        pos++;
      }
    }
    if (tempNode != null && tempNode.data.equals(anEntry))
      return true;
    else 
      return false;
  }
    
    
   public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.data + "\n";;
      currentNode = currentNode.next;
    }
    return outputStr;
  }
}
