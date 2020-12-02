package hu.ad4ayb.web.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

	@NonNull
	private String teacherName;	
	@NonNull
	private List<StudentDto> students;
}
