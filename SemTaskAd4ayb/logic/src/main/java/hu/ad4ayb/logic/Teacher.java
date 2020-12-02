package hu.ad4ayb.logic;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class Teacher {
	
	@Getter
	private String teacherName;	
	@Getter
	private List<Student> students;
	
}
