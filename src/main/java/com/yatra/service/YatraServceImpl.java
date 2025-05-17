package com.yatra.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.yatra.binding.Passenger;
import com.yatra.binding.Ticket;

@Service
public class YatraServceImpl implements YatraService {


	@Override
	public Ticket bookTicket(Passenger passenger) {
		String updateUrl = "http://localhost:8081/bookTicket";
		Passenger pass = new Passenger();  
		  pass.setPassengerName(passenger.getPassengerName());
		  pass.setJourneyDate(passenger.getJourneyDate()); 
		  pass.setTrainNum(passenger.getTrainNum()); 
		  pass.setFromLoc(passenger.getToLoc()); 
		  pass.setToLoc(passenger.getToLoc());
		  Ticket ticket = WebClient. 
		    create(). 
		    post(). 
		    uri(updateUrl). 
		    bodyValue(pass). 
		    retrieve(). 
		    bodyToMono(Ticket.class). 
		    block();
		  System.out.println(ticket);
		  return ticket; 
	}

	@Override
	public Ticket getTicket(String pnr) {
		String  updateUrl= "http://localhost:8081/getTicket/{pnr}";
		Map<String, String> param = new HashMap<>(); 
		  param.put(pnr, updateUrl);
		  Ticket getTicket = WebClient. 
		    create(). 
		    get(). 
		    uri(updateUrl,pnr). 
		    retrieve(). 
		    bodyToMono(Ticket.class). 
		    block(); 
		  return getTicket; 
	}

	@Override
	public Ticket updateTicket(Passenger passenger, String ticketId) {
		String updateUrl = "http://localhost:8081/updateTicket/{pnr}";
		Map<String, String> ticketMap = new HashMap<>(); 
		ticketMap.put(ticketId, updateUrl);
		Passenger updatedPassenger = new Passenger(); 
		updatedPassenger.setJourneyDate(passenger.getJourneyDate()); 
		updatedPassenger.setPassengerName(passenger.getPassengerName()); 
		updatedPassenger.setTrainNum(passenger.getTrainNum()); 
		updatedPassenger.setFromLoc(passenger.getFromLoc()); 
		updatedPassenger.setToLoc(passenger.getToLoc());; 
		Ticket ticket = WebClient. 
		create(). 
		put(). 
		uri(updateUrl,ticketId). 
		bodyValue(updatedPassenger). 
		retrieve(). 
		bodyToMono(Ticket.class). 
		block();  
		return ticket; 
	}

	@Override
	public String cancelTicket(String ticketId) {
		String updateUrl = "http://localhost:8081/cancelTicket/{pnr}";
		String deleteTicket = WebClient. 
			    create(). 
			    delete(). 
			    uri(updateUrl,ticketId). 
			    retrieve(). 
			    bodyToMono(String.class) 
			    .block(); 
			  return deleteTicket; 
	}

   

}