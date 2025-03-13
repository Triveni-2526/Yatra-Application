package com.yatra.service;

import java.util.List;

import com.yatra.binding.Passenger;
import com.yatra.binding.Ticket;

public interface YatraService {

	public Ticket bookTicket(Passenger passengerModel);
    public Ticket getTicket(String pnr);
    public Ticket updateTicket(Passenger passengerModel, String ticketId);
    public String cancelTicket(String ticketId);

}
