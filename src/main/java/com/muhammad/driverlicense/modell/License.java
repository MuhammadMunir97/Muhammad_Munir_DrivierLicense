package com.muhammad.driverlicense.modell;


import java.time.LocalDate;
import java.util.Calendar;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licenses")
public class License {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String number;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expirationDate;
    
    private String state;
    
    @Column(updatable=false)
    private Calendar createdAt;
    
    private Calendar updatedAt;
    
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    
    public License() {
    
    }
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(Long idPerson) {
		StringBuilder tempNum = new StringBuilder(7);
		
		while((idPerson.toString().length() + tempNum.length()) < 7) {
			tempNum.append("0");
		}
		
		tempNum.append(idPerson.toString());
		this.number = tempNum.toString();
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Calendar getCreatedAt() {
		return createdAt;
	}

	public Calendar getUpdatedAt() {
		return updatedAt;
	}
	

	@PrePersist
	protected void onCreate() {
	  createdAt = Calendar.getInstance();
	}

	
	@PreUpdate
	protected void onUpdate() {
	  updatedAt = Calendar.getInstance();
	}

}
