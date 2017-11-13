package ovning3;

import java.util.Comparator;
public class PersonComp implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
	// return p1.namn.compareTo(p2.namn); // kan aven anvandas
	if(p1.namn.equals(p2.namn)){
	    return 0;
	}
	int minLength = Math.min(p1.namn.length(), p2.namn.length());
	for(int index = 0; index < minLength; index++){
	    if (p1.namn.charAt(index) > p2.namn.charAt(index)){
		return -1;
	    }
	    else if(p1.namn.charAt(index) < p2.namn.charAt(index)){
		return 1;
	    }
	    else{
		// Gor inget
	    }
	}
	int pEtt = p1.namn.length();
	int pTva = p2.namn.length();
	if (pEtt > pTva){
	    return 1;
	}
	else{
	    return -1;
	}
	// Sista 8 raderna kan aven forkortas till nedan:
	// return p1.namn.length() > p2.namn.length() ? 1 : -1;
    }
   
}