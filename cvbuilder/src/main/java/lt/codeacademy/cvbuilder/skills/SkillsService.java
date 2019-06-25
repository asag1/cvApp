package lt.codeacademy.cvbuilder.skills;

import lt.codeacademy.cvbuilder.person.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillsService {

    private final SkillsRepository repository;

    @Autowired
    public SkillsService(SkillsRepository repository) {
        this.repository = repository;
    }

    List<SkillsView> getSkillsView() {
        return repository.findAll()
                .stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    void updateSkills(int id, SkillsView updatedSkillsView) {
        Skills skills = find(id);
        if (updatedSkillsView.getSkill() != null) {
            skills.setSkill(updatedSkillsView.getSkill());
        }
        if (updatedSkillsView.getLevel() != null) {
            skills.setLevel(updatedSkillsView.getLevel());
        }
        repository.save(skills);
    }

    void addSkills(SkillsView skillsView) {
        repository.save(mapFromView(skillsView));

    }

    void deleteSkills(int id) {
        repository.deleteById(id);
    }

    private Skills mapFromView(SkillsView skillsView) {
        return new Skills(skillsView.getSkill(), skillsView.getLevel());
    }

    private Skills find(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("SkillsView not found"));
    }

    private SkillsView mapToView(Skills skills) {
        return new SkillsView(skills.getId(), skills.getSkill(), skills.getLevel());
    }
}
