package model;

public class Provider {
	private String pid;
	private String proName;
	private String proDesc;
	private String contact;
	private String phone;
	private String fax;
	private String address;
	
	public Provider() {}
	
	
		
	public Provider(String pid, String proName, String proDesc, String contact, String phone, String fax,
			String address) {
		super();
		this.pid = pid;
		this.proName = proName;
		this.proDesc = proDesc;
		this.contact = contact;
		this.phone = phone;
		this.fax = fax;
		this.address = address;
	}



	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProDesc() {
		return proDesc;
	}

	public void setProDesc(String proDesc) {
		this.proDesc = proDesc;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPid() {
		return pid;
	}



	public void setPid(String pid) {
		this.pid = pid;
	}

	
	
}
