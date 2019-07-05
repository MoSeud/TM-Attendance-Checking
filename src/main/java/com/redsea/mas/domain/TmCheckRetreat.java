package com.redsea.mas.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class TmCheckRetreat {
	public enum CheckRetreatType {
		TMchecking, Retreat
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private CheckRetreatType type;

	@ManyToOne
	@JoinColumn(name = "student_no")
	private Student student;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private LocalDate date;

}
