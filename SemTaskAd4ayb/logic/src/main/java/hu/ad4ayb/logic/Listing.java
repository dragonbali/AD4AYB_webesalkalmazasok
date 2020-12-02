package hu.ad4ayb.logic;

import java.util.ArrayList;
import java.util.List;

public class Listing {
	
	public List<Student> studentListingByTeacherName(String teacherName, List<Student> students){
		List<Student> listedStudents = new ArrayList<Student>();
		for (Student student : students) {
			for (Teacher teacher : student.getTeachers()) {
				if (teacher.getTeacherName().equals(teacherName)) {
					listedStudents.add(student);
				}
			}
		}
		return listedStudents;	
	}

	public Student getStudentByName (String studentName, List<Student> students){
		Student returnedStudent = new Student();
		for (Student student : students) {
			if (student.getStudentName().equals(studentName)) {
				returnedStudent = student;
			}
		}
		return returnedStudent;
	}
}
