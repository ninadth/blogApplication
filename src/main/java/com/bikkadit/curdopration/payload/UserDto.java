package com.bikkadit.curdopration.payload;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bikkadit.curdopration.model.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	
    private long userId;
    
    @NotEmpty
	@Size(min=4,max=10, message="USERNAME MUST BE MIN 4 AND MAX 10 CHARACTER ENTER")
	private String userFirstName;
    
    @NotEmpty
   	@Size(min=4,max=10, message="USERNAME MUST BE MIN 4 AND MAX 10 CHARACTER ENTER")
	private String userLastName;
    
    @Email
	private String userEmail;
    
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String about;
	
	private Set<Role> roles = new HashSet<>();

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public UserDto(long userId,
			@NotEmpty @Size(min = 4, max = 10, message = "USERNAME MUST BE MIN 4 AND MAX 10 CHARACTER ENTER") String userFirstName,
			@NotEmpty @Size(min = 4, max = 10, message = "USERNAME MUST BE MIN 4 AND MAX 10 CHARACTER ENTER") String userLastName,
			@Email String userEmail, @NotEmpty String password, @NotEmpty String about, Set<Role> roles) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.password = password;
		this.about = about;
		this.roles = roles;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", userEmail=" + userEmail + ", password=" + password + ", about=" + about + ", roles=" + roles + "]";
	}
	
	
	
	
}

	