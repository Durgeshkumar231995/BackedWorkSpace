package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class flight {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int flightid;
	@NotBlank(message = "Flight No cant be Blank")
	private String flightno;
	@NotBlank(message = "Flight name cant be blank")
	@NotEmpty(message = "Flight name cant be empty")
	@Size(min=2,max=20,message="Filght bane should be more than 2 and less than 20")
		private String flightname;
	public int getFlightid() {
		return flightid;
	}
//	public flight(int flightid, @NotBlank(message = "Flight No cant be Blank") String flightno,
//			@NotBlank(message = "Flight name cant be blank") @NotEmpty(message = "Flight name cant be empty") @Size(min = 2, max = 20, message = "Filght bane should be more than 2 and less than 20") String flightname) {
//		super();
//		this.flightid = flightid;
//		this.flightno = flightno;
//		this.flightname = flightname;
//	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public String getFlightname() {
		return flightname;
	}
	public void setFlightname(String flightname) {
		this.flightname = flightname;
	}

}
