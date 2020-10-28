package model;

/**
 * @author Mm
 *
 */
public class User {
	private int id;

	public String username;

	private String password;

	private int sex;

	private int age;

	private int tel;
	
	private String email;

	private String address;

	private int issupper;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public  int getTel() {
		return  tel;
	}
	
	public void setTel(int tel) {
		this.tel = tel;
	}

	
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return email;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}
	
	
	public int getIssupper() {
		return issupper;
	}
	public void setIssupper(int issupper) {
		this.issupper = issupper;
	}
	public String toString(){
		String re;
		
		re = "ID:	" + this.getId()+"\n sex:" + this.getSex()+"\n age:	" + this.getAge()
		   + "\n User Name  	" + this.getUsername() + "\n Password  " + this.getPassword()
		   + "\n tel 	" + this.getTel()+"\n email	" + this.getEmail()+"\n address  " + this.getaddress();
		
		return re;		
	}


}
