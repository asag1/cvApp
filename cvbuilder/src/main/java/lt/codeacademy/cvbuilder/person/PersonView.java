package lt.codeacademy.cvbuilder.person;

import java.util.Objects;

public class PersonView {

    private String firstName;
    private String secondName;
    private String aboutMe;

    public PersonView(String firstName, String secondName, String aboutMe) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.aboutMe = aboutMe;
    }

    public PersonView() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public String toString() {
        return "PersonView{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonView that = (PersonView) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }
}
