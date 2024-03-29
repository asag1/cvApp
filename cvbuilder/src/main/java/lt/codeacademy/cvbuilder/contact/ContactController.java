package lt.codeacademy.cvbuilder.contact;

import lt.codeacademy.cvbuilder.person.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/contacts")
@CrossOrigin("*")
public class ContactController {

    private final ContactService service;

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping
    public List<ContactView> getContacts() {
        return service.getContactViews();
    }

    @GetMapping(path = "/types")
    public List<ContactType> getContactsType() {
        return Arrays.asList(ContactType.values());
    }

    @PostMapping(path = "/add")
    public ContactView addContact(@RequestBody ContactView contactView) {
        return service.addContact(contactView);
    }

    @PutMapping(path = "/update/{id}")
    public void updateContact(@PathVariable("id") int id, @RequestBody ContactView contactView) {
        service.updateContact(id, contactView);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteContact(@PathVariable("id") int id) {
        service.deleteContact(id);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, NotFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void handleNotFoundException() {

    }
}
