package com.example.WebSecurity.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name = "userdetails")
//@NamedQuery(query = "select u.email, r.role from user u inner join userrole ur on(u.user_id=ur.user_id) inner join role r on(ur.role_id=r.role_id) where u.email=?", name = "query")
public class User {
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "user_id")
	   @Getter@Setter
	    private int id;
	    @Column(name = "email")
	    @Email(message = "*Please provide a valid Email")
	    @NotEmpty(message = "*Please provide an email")
	    @Getter@Setter
	    private String email;
	    @Column(name = "password")
	    @Length(min = 5, message = "*Your password must have at least 5 characters")
	    @NotEmpty(message = "*Please provide your password")
	    @Getter@Setter
	    private String password;
	    @Column(name = "name")
	    @NotEmpty(message = "*Please provide your name")
	    @Getter@Setter
	    private String name;
	    @Column(name = "last_name")
	    @NotEmpty(message = "*Please provide your last name")
	    @Getter@Setter
	    private String lastName;
	    @Column(name = "active")
	    @Getter@Setter
	    private int active;
	    @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private Set<Role> roles;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public int getActive() {
			return active;
		}
		public void setActive(int active) {
			this.active = active;
		}
		public Set<Role> getRoles() {
			return roles;
		}
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}
	    
}