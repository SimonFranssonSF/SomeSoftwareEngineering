package ovning3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

class Person implements Comparable<Person> {
    long pnr;
    String namn;
    Person (long p, String n) {
    	pnr = p;
        namn = n;
    }

    public String toString() {
    	return namn + " " + pnr;
    }
    
    @Override
    public int compareTo(Person other) {
		if (this.pnr > other.pnr){
		    return -1;
		}
		else if(this.pnr < other.pnr){
		    return 1;
		}
		else{
		    return 0;
		}
	}
    
    public static void main(String[] args) {
    	// Denna main-metod kan aven ligga i en egen klass
    	Person a = new Person(1234567891234L, "Erik");
    	Person b = new Person(2234567891234L, "Erika");
    	Person c = new Person(3234567891234L, "c");
    	
    	ArrayList<Person> al = new ArrayList<Person>();
    	al.add(a);
    	al.add(b);
    	al.add(c);
    	Collections.shuffle(al);
    	
    	// Skapa TreeSet som tar emot objekt av typen Person.
    	// Placerar objekten utifran eventuell Comparable
    	// TreeSet kan aven ta emot en Comparator (PersonComp) som 
    	// parameter:
    	// new TreeSet<Person>(new PersonComp());
    	TreeSet<Person> ts = new TreeSet<Person>();
    	ts.addAll(al);
    	
    	// Uppgift 2.c
    	Iterator<Person> i = ts.iterator();
    	while(i.hasNext()){
    	    System.out.println(i.next());
    	}
    	
    	// Uppgift 2.d
    	Collections.sort(al);
    	for(Person p: al){
    	    System.out.println(p);
    	}
    	
    	// Uppgift 2.e
    	Collections.sort(al, new PersonComp());
    	for(Person p: al){
    	    System.out.println(p);
    	}

    	System.out.println("Uppgift 2.e med TreeSet");
    	// TreeSet kan aven ta emot en Comparator (PersonComp) 
    	// som parameter:
    	TreeSet<Person> ts1 = new TreeSet<Person>(new PersonComp());
    	ts1.addAll(al);
    	for(Iterator<Person> it = ts1.iterator(); it.hasNext();){
    	    System.out.println(it.next());
    	}
        }
}