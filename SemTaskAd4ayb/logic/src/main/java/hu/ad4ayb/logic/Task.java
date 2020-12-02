package hu.ad4ayb.logic;

import java.util.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class Task {

	
	@Getter
	private String title;
	@Getter
	private Date date;
	@Getter
	private boolean isDone;
	@Getter
	private String solution;
	@Getter
	private String comment;
}
