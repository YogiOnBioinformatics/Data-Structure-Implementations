

import java.io.*;
import java.util.*;
import java.lang.*;

public class Profile implements ProfileInterface {
	
	private String name = null;
	private String aboutMe = null;
	private Set<ProfileInterface> set = new Set<ProfileInterface>();
	private ProfileInterface[] profileInterfaceArr = new ProfileInterface[100];
	private int profileInterfaceArrCount = 0;
	
	public Profile(){
		
		name = "";
		aboutMe = "";
	}
	
	public Profile(String inputName, String inputAboutMe){
		
		if (inputName == null){ 
			
			throw new IllegalArgumentException();
		}
		name = inputName;
		aboutMe = inputAboutMe;
	}
	
	public void setName(String inputName){
		
		if(inputName == null){
			throw new IllegalArgumentException();
		}
		
		name = inputName;
		
	}
	
	public String getName(){
		return name;
		
	}
	
	public void setAbout(String about){
		
	if(about == null){
		throw new IllegalArgumentException();
	}
	
	aboutMe = about;
		
	}
	
	public String getAbout(){
		
		return aboutMe;
	}
	
	public boolean follow(ProfileInterface other){
		
		
		if(other == null){
			
			return false;
		}
		
		try{
			set.add(other);
			profileInterfaceArr[profileInterfaceArrCount] = other;
			profileInterfaceArrCount++;
			return true;
			
		}
		catch(SetFullException e){
			
			
		}
		
		
		return true;
		
	}
	
	public boolean unfollow(ProfileInterface other){
		
		if(other == null) {
				return false;
		}
		else if(set.remove(other)){
			return true;
		}
		else if(!set.remove(other)){
			return false;
		}
		
		return false;
	}
	
	public ProfileInterface[] following(int howMany){
		
		ProfileInterface[] returnArray = new ProfileInterface[howMany];
		
		if(profileInterfaceArrCount>howMany){
			
			for(int i = 0; i<howMany; i++){
				
				returnArray[i] = profileInterfaceArr[i];
			}
			
			return returnArray;
		}
		else if(profileInterfaceArrCount<howMany){
			
			for(int i =0; i<profileInterfaceArrCount; i++){
				
				returnArray[i] = profileInterfaceArr[i];
			}
			return returnArray;
		}
		
		return returnArray;
		
		
	
	}
	
	public ProfileInterface recommend() {
		
		Object[] followers = set.toArray();
		
		
		
		for(int i =0; i<followers.length;i++){
			
			Profile person = (Profile) followers[i];
			
			for(int j =0;i<person.set.toArray().length;j++){
				
				
				
			}
			
			
			
		}
		Profile recommend = new Profile();
		
		return recommend;
	
	}
	

	
	
	
	
	
	
	
	
}