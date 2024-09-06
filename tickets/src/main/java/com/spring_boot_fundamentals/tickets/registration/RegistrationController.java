package com.spring_boot_fundamentals.tickets.registration;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/registrations")
public class RegistrationController {
    private final RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    //use the save method from MongoRepository
    @PostMapping
    public Registration create(@RequestBody @Validated Registration registration) {
        return registrationRepository.save(registration);
    }

    //use the save method from MongoRepository
    @PutMapping
    public Registration update (@RequestBody Registration registration) {
        //Lookup the existing registration by ticket code:
        String ticketCode = registration.ticketCode();
        var existing = registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code "+ticketCode+ " not found"));
        //Only update the attendee name
        return registrationRepository.save(new Registration(existing.id(), existing.productId(),ticketCode, registration.attendeeName()));
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration get(@PathVariable("ticketCode") String ticketCode){
        return registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticket code " + ticketCode + " not found"));
    }

    @DeleteMapping(path="/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        registrationRepository.deleteByTicketCode(ticketCode);
    }
}
