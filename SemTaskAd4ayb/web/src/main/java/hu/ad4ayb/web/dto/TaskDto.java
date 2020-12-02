package hu.ad4ayb.web.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

	@NonNull
	private String title;
	@NonNull
	private Date deadline;
	private Date receiptTime;
	@NonNull
	private String solution;
	@NonNull
	private String comment;
}
