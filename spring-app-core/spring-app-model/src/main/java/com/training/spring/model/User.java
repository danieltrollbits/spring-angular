package com.training.spring.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Table(name = "USERS")
public class User extends BaseEntity {

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "enabled")
	private boolean enabled = false;

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_USER_ROLES", 
             joinColumns = { @JoinColumn(name = "user_id", updatable = false) }, 
             inverseJoinColumns = { @JoinColumn(name = "user_role_id", updatable = false) })
	private Set<UserRole> userRole = new HashSet<UserRole>(0);

	@Column(name = "name")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private UserStatus userStatus = UserStatus.PENDING;

	public User() {
	}

	public User(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public User(String username, String password, String name, Set<UserRole> userRole) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.userRole = userRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public UserStatus getUserStatus(){
		return this.userStatus;
	}

	public void setUserStatus(UserStatus userStatus){
		this.userStatus = userStatus;
	}

}
