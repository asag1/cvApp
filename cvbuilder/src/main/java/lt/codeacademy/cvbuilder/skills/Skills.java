package lt.codeacademy.cvbuilder.skills;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String skill;
//    @Enumerated(EnumType.STRING)
    private SkillsLevel level;

    public Skills(String skill, SkillsLevel level) {
        this.skill = skill;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public SkillsLevel getLevel() {
        return level;
    }

    public void setLevel(SkillsLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id=" + id +
                ", skills='" + skill + '\'' +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skills skills = (Skills) o;
        return id == skills.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
