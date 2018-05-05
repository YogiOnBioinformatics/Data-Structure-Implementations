

import java.lang.*;
import java.io.*;
import java.util.*;

public class Set <E> implements SetInterface<E>{
	
	private int indexToRemove;
	private E[] elems;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Set()
	{
		size = 0; 
		elems = (E[]) new Object[10];
	}
	
	@SuppressWarnings("unchecked")
	public Set(int x)
	{
		size =0;
		elems = (E[]) new Object[x];
	}
	
	
	
	@SuppressWarnings("unchecked")
	public Set(E[] contents) 
	{
		elems = (E[]) new Object[contents.length];
		
		for(int i =0; i<contents.length; i++){
			elems[i] = contents[i];
		}
		size = contents.length;
		
	}
	
	
	public boolean add(E entry) throws SetFullException, IllegalArgumentException {
	
		if(entry == null) {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i<size; i++)
		{
			if(elems[i].equals(entry)){
				return false;
			}
		}
		
		if(size==elems.length){
			resize();
		}
		
		elems[size] = entry;
		
		size++;
			
		
		return true;
	}
	
	/*private boolean equals(E entry){				
		
		for(int i =0; i<size; i++){					IGNORE THIS! THIS WAS FAILED CODE THAT I LEFT HERE.
			
			if(elems[i] == entry){
				indexToRemove = i;
				return true;
				
			}
		}
		
		return false; 
		
	} */
	
	public int getCurrentSize(){
	
		return size;
		
	
	}
	
	@SuppressWarnings("unchecked")
	private void resize(){
		
		E[] resize = (E[]) new Object[elems.length*2];
		for(int i = 0; i<elems.length; i++)
		{
			resize[i] = elems[i];
		}
		elems = resize;
	

	} 		
	
	public boolean isEmpty(){
		
		if(size == 0){
			return true;
		}
		
		return false;
		
	}
	
	public boolean remove(E entry) throws IllegalArgumentException {
		
		if(entry == null) {
			throw new IllegalArgumentException();
			
		}
		
		for(int i =0; i<size; i++){
			
			if(elems[i] == entry){
				if(i == size-1){
					elems[size-1] = null;
					size--;
					return true;
				}
				else{
					elems[i] = elems[size-1];
					elems[size-1] = null;
					size--;
					return true;
				}
			}
		}
		
		return false;
		
	}
	
	public E remove(){
		
		if(size ==0){
			return null;
		}
		if(size>0){
			E returnElement =elems[size-1];
			elems[size-1] = null;
			size--;
			return returnElement;
		}
		return null;
	}
	
	public void clear(){
		if(size>0){
			for(int i =0; i<size; i++){
				elems[i] = null;
			}
		size = 0;
		}
		
	}
	
	public boolean contains(E entry) throws IllegalArgumentException {
		
		if(entry == null){
			throw new IllegalArgumentException();
		}
		
		for(int i =0; i<size; i++){
			if(elems[i] == entry){
				return true;
			}
		}
		
		return false;
		
	}
	
	public E[] toArray(){
		E[] returnArray =(E[]) new Object[size];
		
		for(int i =0; i<size;i++)
		{
			returnArray[i] = elems[i];
		}
		
		return returnArray;
	}
	
	public void printSet(){
		
		for(int i =0; i<size; i++){
			System.out.println(elems[i]);
		}
	}
		
	
	
	
	

}