

import java.util.*;
import java.io.*;
import java.lang.*;

public class test<E>{
	
	public static void main (String[] args) throws SetFullException {
		
		
		Object[] datArray = new Object[] {"hey", 1, 7.40, "lol", 123.88809};
		
		Set<Object> theSet = new Set<Object>(datArray);
		
		Profile daProfile = new Profile("Yogi", "I'm cool");
		Profile testProfile = new Profile("name 1", "I'm cool");
		Profile testProfile2 = new Profile("name 2", "I'm cool");
		
		System.out.println(daProfile.follow(testProfile));
		
		System.out.println(daProfile.follow(testProfile2));
		
		System.out.println(daProfile.recommend());
		
		
		
	}
	
}