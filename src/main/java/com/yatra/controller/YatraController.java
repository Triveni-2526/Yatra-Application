package com.yatra.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatra.binding.Passenger;
import com.yatra.binding.Ticket;
import com.yatra.service.YatraService;

@RestController
@RequestMapping("/yatra")
public class YatraController {

    private final YatraService yatraService;

    public YatraController(YatraService yatraService) {

		this.yatraService = yatraService;
	}

    @PostMapping("/bookTicket")
    public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger) {
        Ticket bookedTicket = yatraService.bookTicket(passenger);
        return new ResponseEntity<>(bookedTicket, HttpStatus.CREATED);
    }

    @GetMapping("/getTicket/{pnr}")
    public ResponseEntity<Ticket> getTicket(@RequestBody @PathVariable("pnr") String pnr) {
        Ticket ticket = yatraService.getTicket(pnr);
        return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
    }
    @PutMapping("/updateTicket/{pnr}")
   
    	public ResponseEntity<Ticket> updatedTicketDataFromRestController(@PathVariable String pnr,@RequestBody Passenger passenger){
    		Ticket trainInformation = yatraService.updateTicket(passenger, pnr);
    		return new ResponseEntity<Ticket>(trainInformation, HttpStatus.OK);
    }

    @DeleteMapping("/cancelTicket/{pnr}")
    public ResponseEntity<String> deleteTicket(@PathVariable String pnr) {
        String deleteticket = yatraService.cancelTicket(pnr);
       if(deleteticket != null)
       {
    	   return new ResponseEntity<String>("Ticket with pnr"+ pnr +"has been cancelled.",HttpStatus.NOT_FOUND);
       }
       else
       {
    	   return new ResponseEntity<String>("Ticket not found with pnr "+ pnr ,HttpStatus.NOT_FOUND);
       }
    }

    
   
}
