package net.yakovlev.model;

public class Users {
  
	private static final long serialVersionUID = 1L;
	  
	public static final String GENDER_MALE ="M";
	 
	public static final String GENDER_FEMALE = "F";	  
	
    private String userName;
    
    private String gender;
    
    private String password;
	     
    	public Users() {
		
	}
    	
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
    
    
}
