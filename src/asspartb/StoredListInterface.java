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
public interface StoredListInterface<T extends Comparable<? super T>> {
    public boolean add(T newEntry);
    public int getLength();
    public T getEntry(int givenPosition);
    public boolean contains(T anEntry);
    //public T getEntryForUpdate(int givenPosition);
    public boolean replace(int givenPosition, T newEntry);
     public boolean isEmpty() ;
}
