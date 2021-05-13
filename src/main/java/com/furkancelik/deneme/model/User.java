package com.furkancelik.deneme.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	
	@Column(unique = true )
	private String mail;
	private String password;
	private String role;
	
	@OneToMany(targetEntity = Education.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName =  "id")
	private List<Education> educations;
	
	
	@OneToMany(targetEntity = Reference.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private List<Reference> references;
	
	
	@OneToMany(targetEntity = Experience.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private List<Experience> experience;
	

	@OneToMany(targetEntity = Hobi.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private List<Hobi> hobbies;
	

	@OneToMany(targetEntity = Skill.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private List<Skill> skills;
	

	
	public User() {}



	public User(int id, String name, String surname, String mail, String password, String role,
			List<Education> educations, List<Reference> references, List<Experience> experience, List<Hobi> hobbies,
			List<Skill> skills) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.role = role;
		this.educations = educations;
		this.references = references;
		this.experience = experience;
		this.hobbies = hobbies;
		this.skills = skills;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}



	public List<Reference> getReferences() {
		return references;
	}



	public void setReferences(List<Reference> references) {
		this.references = references;
	}




	public List<Experience> getExperience() {
		return experience;
	}




	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}



	public List<Hobi> getHobbies() {
		return hobbies;
	}



	public void setHobbies(List<Hobi> hobbies) {
		this.hobbies = hobbies;
	}



	public List<Skill> getSkills() {
		return skills;
	}



	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}
	
	
}
















