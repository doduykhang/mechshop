package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column(name = "username")
	@NotBlank(message = "Tên đăng nhập không được để trống")
	@Size(min = 1, max = 50, message = "Tên đăng nhập trong khoảng 1 đến 50 ký tự")
	private String userName;

	@Column(name = "password")
	@NotBlank(message = "Mật khẩu không được để trống")
	@Size(min = 6, max = 255, message = "Mật khẩu trong khoảng 6 đến 50 ký tự")
	private String password;

	@Column(name = "fullname")
	@NotBlank(message = "Họ và tên không được để trống")
	@Size(min = 1, max = 50, message = "Họ và tên trong khoảng 1 đến 50 ký tự")
	private String fullName;

	@Column(name = "status")
	private Integer status;

	@Column(name = "validationToken")
	private String validationToken;
	
	@Column(name = "email")
	@NotBlank(message = "Email không được để trống")
	@Size(max = 50, message = "Email trong khoảng tối đa 50 ký tự")
	@Email(message = "Email không đúng định dạng")
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid"), 
								  inverseJoinColumns = @JoinColumn(name = "roleid"))
	private List<RoleEntity> roles = new ArrayList<>();

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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public String getValidationToken() {
		return validationToken;
	}

	public void setValidationToken(String validationToken) {
		this.validationToken = validationToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
