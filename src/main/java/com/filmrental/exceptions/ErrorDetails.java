package com.filmrental.exceptions;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
 
public class ErrorDetails {
 
    private LocalDate dateTime;
    private String message;
	@Override
	public String toString() {
		return "ErrorDetails [dateTime=" + dateTime + ", message=" + message + "]";
	}
 
    


}
