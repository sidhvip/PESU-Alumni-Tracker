package edu.pes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import org.springframework.data.annotation.Transient;


@Entity
@Table(name = "pesuat")
public class Alumni {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "year")
	private String year;
	
	@Column(name = "course")
	private String course;
	
	@Column(name = "dept")
	private String dept;
	
	@Column(name = "srn")
	private String srn;
	
	@Column(name = "cgpa")
	private String cgpa;
	

	@Column(name = "chapter")
	private String chapter;
	
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	

	@Column(name = "achivements")
	private String achivements;
	
	@Column(name = "placed")
	private String placed;
	
	@Column(name = "image")
	private String image;
	

	@Column(name = "click")
	@Transient
	private int click;


	@OneToOne(mappedBy = "alumni")
    private User user;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public String getSrn() {
		return srn;
	}


	public void setSrn(String srn) {
		this.srn = srn;
	}


	public String getCgpa() {
		return cgpa;
	}


	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}


	public String getChapter() {
		return chapter;
	}


	public void setChapter(String chapter) {
		this.chapter = chapter;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAchivements() {
		return achivements;
	}

	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setAchivements(String achivements) {
		this.achivements = achivements;
	}


	public String getPlaced() {
		return placed;
	}


	public void setPlaced(String placed) {
		this.placed = placed;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getClick() {
		return click;
	}


	public void setClick(int click) {
		this.click = click;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Alumni [id=" + id + ", name=" + name + ", year=" + year + ", course=" + course + ", dept=" + dept
				+ ", srn=" + srn + ", cgpa=" + cgpa + ", chapter=" + chapter + ", email=" + email + ", address="
				+ address + ", phone=" + phone + ", achivements=" + achivements + ", placed=" + placed + ", image=" + image
				+ ", click=" + click + "]";
	}

}