package org.oday.Messanger.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.oday.Messanger.db.DataBase;
import org.oday.Messanger.model.Message;
import org.oday.Messanger.model.Profile;

public class ProfileService {

	private Map<String ,Profile> profiles=DataBase.profiles;
	
	public ProfileService() {
		// TODO Auto-generated constructor stub
		profiles.put("profile 1", new Profile(1l, "profile 1", "Profile Oday","Yameen"));
		profiles.put("profile 2", new Profile(2l, "profile 2", "Profile Oday","Yameen"));
		profiles.put("profile 3", new Profile(3l, "profile 3", "Profile Oday","Yameen"));
	}
	public List<Profile>getAllProfile(){
		
		return new ArrayList<Profile>(profiles.values());
		
	}
	public Profile getProfile(String ProfileName) {
		
		return profiles.get(ProfileName);
		
	}
	
	public Profile addProfile(Profile p) {
		
		p.setId(profiles.size()+1);
		
		profiles.put(p.getProfileName(),p);
		return p;
	}
	
	public Profile updateProfile(Profile p) {
		if(p.getProfileName().isEmpty())
			return null;
		else {
			
			Profile m2=	profiles.getOrDefault(p.getProfileName() ,null);
			if(m2==null)return null;
			else profiles.put(m2.getProfileName(),p);
			}
		return p;
	}
	
	
	public Profile deleteProfile(String profileName) {
		
		return profiles.remove(profileName);
		
	}
	
}
