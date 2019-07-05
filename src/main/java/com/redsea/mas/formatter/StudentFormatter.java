package com.redsea.mas.formatter;

import com.redsea.mas.domain.Student;
import com.redsea.mas.repository.StudentRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class StudentFormatter implements Formatter<Student>, Converter<String, Student> {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public String print(Student object, Locale locale) {
		return object.getId().toString();
	}

	@Override
	public Student parse(String text, Locale locale) throws ParseException {
		if (StringUtils.isEmpty(text)) {
			return null;
		}
		try {
			return studentRepository.findById(Long.parseLong(text)).orElse(null);
		} catch (Exception e) {
			return null;

		}
	}

	@Override
	public Student convert(String source)
	{
		return studentRepository.findById(Long.parseLong(source)).get();
	}

}
