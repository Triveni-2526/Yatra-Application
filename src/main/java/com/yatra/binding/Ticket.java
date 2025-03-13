package com.yatra.binding;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	private String fromLoc;
	private String toLoc;
	private String passengerName;
	private LocalDate journeyDate;
	private Long trainNum;
	private String pnr;
	private String ticketStatus;
	private Double ticketPrice;
}
