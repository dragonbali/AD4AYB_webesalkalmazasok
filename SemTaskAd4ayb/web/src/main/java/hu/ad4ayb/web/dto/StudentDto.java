package hu.ad4ayb.web.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

	@NonNull
	private String studentName;
	@NonNull
	private List<TeacherDto> teachers;
	@NonNull
	private List<TaskDto> tasks;
}
