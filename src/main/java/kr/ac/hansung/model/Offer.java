package kr.ac.hansung.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

@ToString
public class Offer {
	
	
	public Offer(String string, int sum) {
		this.division = string;
		this.grades = sum;
	}
	private int year;
	
	private int semester;
	private String code;

	@NotEmpty(message ="The semester cannot be empty")
	private String subject;
	private String division;
	private int grades;
		
	
}