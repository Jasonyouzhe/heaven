package com.im.heaven.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "t_user",catalog = "heaven")
public class User {

	public Integer id;
	public String username;
	public String password;
	private List<Role> roleList;//一个用户具有多个角色 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	@Column(name = "username")
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    @ManyToMany  
    @JoinTable(name="t_user_role",joinColumns={@JoinColumn(name="user_id")},inverseJoinColumns={@JoinColumn(name="role_id")})  
    public List<Role> getRoleList() {  
        return roleList;  
    }  
    public void setRoleList(List<Role> roleList) {  
        this.roleList = roleList;  
    }  
      
    @Transient  
    public Set<String> getRolesName(){  
        List<Role> roles=getRoleList();  
        Set<String> set=new HashSet<String>();  
        for (Role role : roles) {  
            set.add(role.getRolename());  
        }  
        return set;  
    } 
}
