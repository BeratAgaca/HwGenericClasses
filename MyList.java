package odevListeSinifiYapmak;

import java.util.Arrays;


public class MyList <T>{
	private Object[] myArray;
	public int counter=0, capacity= 10;
	
	
	public MyList() {
		//10 elemanlı array
		this.myArray = new Object[this.capacity];
	}
	public MyList(int capacity) { 
		//capacity amount elemanlı array
		this.myArray = new Object[capacity];
	}
	
	public int getCapacity(){
		return this.myArray.length;
	}
	
	public int size() {
		return counter;
	}
	
	public void add(T data) {
		if(this.myArray.length <= counter) {
			this.myArray = Arrays.copyOf(this.myArray, this.myArray.length*2);
		}
		this.myArray[counter] = data;
		counter++;
	}
	public Object get(int index) {
		if(index<0 || index>counter) {
			return null;
		}
		else {
			return this.myArray[index];
		}
	}
	
	public Object[] remove(int index) {
		if(index<0 || index>counter) {
			return null;
		}
		else {
			for(int i=index; i<counter; i++) {
				this.myArray[i] = this.myArray[i+1];
			}
			this.myArray[counter] = null;
			counter = counter-1;
			return this.myArray;
		}
		
		
	}
	
	//returns the old data but changes with new data
	public Object set(int index, T data) { 
		Object temp;
		if(index<0 || index>counter) {
			return null;
		}
		else {
			temp = this.myArray[index];
			this.myArray[index] = data;
			return temp;
			
		}
	}
	
	//Sınıfa ait dizideki elemanları listeleyen bir metot.
	public String toString() {
		String s = "[";
		for(int i =0; i<counter; i++) {
			s+= this.myArray[i].toString();
			if(i==counter-1) {
				break;
			}
			s+=",";
		}
		return s+"]";
	}
	
	//linear search //it can be improved if we have any info about stored data in myArray
	public int indexOf(T data) {
		for(int i = 0; i<counter; i++) {
			if(this.myArray[i] == data) {
				return i;
			}
		}
		return -1;
	}
	public int lastIndexOf(T data) {
		for(int i = counter-1; i>=0; i--) {
			if(this.myArray[i] == data) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isEmpty() {
		if(counter == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//? Listedeki öğeleri, aynı sırayla bir array haline getirir.
	public Object[] toArray() {
		return this.myArray;
	}
	
	
	//Listedeki bütün öğeleri siler, boş liste haline getirir.
	public void clear() {
		this.myArray = Arrays.copyOf(this.myArray, 0);
		this.myArray = Arrays.copyOf(this.myArray, 10);
		counter=0;
	}
	
	// Parametrede verilen indeks aralığına ait bir liste döner.
	public MyList<T> subList(int start,int finish){
		MyList<T> temp = new MyList<>();
		for(int i=start; i<=finish; i++) {
			temp.add((T) this.get(i)); //????
		}
		return temp;
	}
	
	//Parametrede verilen değerin dizide olup olmadığını söyler.
	public boolean contains(T data) {
		return this.indexOf(data) != -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
