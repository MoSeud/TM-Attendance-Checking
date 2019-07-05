package com.redsea.mas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.redsea.mas.domain.Student;
import com.redsea.mas.domain.TmCheckRetreat;
import com.redsea.mas.validator.RetreatDateStudent;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@RetreatDateStudent(message = "The Student has done the check for the same day.")
public class TmCheckRetreatDto {
	private Long id;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent
	private LocalDate date;

	@NotNull
	private TmCheckRetreat.CheckRetreatType type;

	@NotNull
	private Student student;
}
