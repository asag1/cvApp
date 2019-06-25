package lt.codeacademy.cvbuilder.education;

import lt.codeacademy.cvbuilder.person.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {

    private final EducationRepository repository;

    @Autowired
    public EducationService(EducationRepository repository) {
        this.repository = repository;
    }

    List<EducationView> getEducationView() {
        return repository.findAll()
                .stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    void updateEducation(int id, EducationView updatedEducationView) {
        Education education = find(id);
        if (updatedEducationView.getDataStart() != null) {
            education.setDataStart(updatedEducationView.getDataStart());
        }
        if (updatedEducationView.getDataEnd() != null) {
            education.setDataEnd(updatedEducationView.getDataEnd());
        }
        if (updatedEducationView.getDegree() != null) {
            education.setDegree(updatedEducationView.getDegree());
        }
        if (updatedEducationView.getUniversity() != null) {
            education.setUniversity(updatedEducationView.getUniversity());
        }
        repository.save(education);
    }

    void addEducation(EducationView educationView) {
        repository.save(mapFromView(educationView));
    }

    void deleteEducation(int id) {
        repository.deleteById(id);
    }

    private Education mapFromView(EducationView educationView) {
        return new Education(educationView.getDataStart(), educationView.getDataEnd(),
                educationView.getUniversity(), educationView.getDegree());
    }

    private Education find(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("EducationView not found"));
    }

    private EducationView mapToView(Education education) {
        return new EducationView(education.getId(), education.getDataStart(), education.getDataEnd(),
                education.getUniversity(), education.getDegree());
    }

}
