package lt.codeacademy.cvbuilder.skills;

import lt.codeacademy.cvbuilder.person.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/skills")
@CrossOrigin("*")
public class SkillsController {

    private final SkillsService service;

    @Autowired
    public SkillsController(SkillsService service) {
        this.service = service;
    }

    @GetMapping
    public List<SkillsView> getSkills() {
        return service.getSkillsView();
    }

    @PostMapping(path = "/add")
    public void addSkills(@RequestBody SkillsView skillsView) {
        service.addSkills(skillsView);
    }

    @PutMapping(path = "/update/{id}")
    public void updateSkils(@PathVariable("id") int id, @RequestBody SkillsView skillsView) {
        service.updateSkills(id, skillsView);
    }

    public void deleteSkills(@PathVariable("id") int id) {
        service.deleteSkills(id);
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, NotFoundException.class})
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void handleNotFoundException() {
    }
}
