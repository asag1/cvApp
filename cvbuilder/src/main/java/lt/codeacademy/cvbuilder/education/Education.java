package lt.codeacademy.cvbuilder.education;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dataStart;
    private String dataEnd;
    private String university;
    private String degree;

    public Education(String dataStart, String dataEnd, String university, String degree) {
        this.dataStart = dataStart;
        this.dataEnd = dataEnd;
        this.university = university;
        this.degree = degree;
    }

    public Education() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataStart() {
        return dataStart;
    }

    public void setDataStart(String dataStart) {
        this.dataStart = dataStart;
    }

    public String getDataEnd() {
        return dataEnd;
    }

    public void setDataEnd(String dataEnd) {
        this.dataEnd = dataEnd;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", dataStart='" + dataStart + '\'' +
                ", dataEnd='" + dataEnd + '\'' +
                ", university='" + university + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return id == education.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
