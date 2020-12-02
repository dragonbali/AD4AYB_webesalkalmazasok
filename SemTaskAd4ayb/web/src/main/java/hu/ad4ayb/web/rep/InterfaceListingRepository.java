package hu.ad4ayb.web.rep;

import java.util.Date;
import java.util.List;

import hu.ad4ayb.web.dto.StudentDto;

public interface InterfaceListingRepository {

	Boolean notOrLate(Date deadline, Date receiptTime);
	List < Boolean > isOkList(List < StudentDto > students);
	List<StudentDto> getStudents();	
}
