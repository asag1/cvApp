package lt.codeacademy.cvbuilder.skills;

import java.util.Objects;

public class SkillsView {

    private int id;
    private String skill;
    private SkillsLevel level;

    public SkillsView(int id, String skill, SkillsLevel level) {
        this.id = id;
        this.skill = skill;
        this.level = level;
    }

    public SkillsView() {
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
        return "SkillsView{" +
                "id=" + id +
                ", skills='" + skill + '\'' +
                ", level=" + level +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillsView that = (SkillsView) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
