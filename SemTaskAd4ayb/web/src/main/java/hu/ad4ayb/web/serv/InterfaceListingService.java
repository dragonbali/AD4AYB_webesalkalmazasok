package hu.ad4ayb.web.serv;

import java.util.Date;
import java.util.List;

import hu.ad4ayb.web.dto.StudentDto;


public interface InterfaceListingService {
	
	 Boolean notOrLate (Date deadline, Date receiptTime);
	 List<Boolean> isOkList (List<StudentDto> students);
	 List<StudentDto> getStudents();	

}
