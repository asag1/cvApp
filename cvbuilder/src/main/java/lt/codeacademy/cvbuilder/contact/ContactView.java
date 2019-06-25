package lt.codeacademy.cvbuilder.contact;

import java.util.Objects;

public class ContactView {

    private int id;
    private String value;
    private ContactType type;
    private String link;


    public ContactView(int id, String value, ContactType type, String link) {
        this.id = id;
        this.value = value;
        this.type = type;
        this.link = link;
    }

    public ContactView() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "ContactView{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", type=" + type +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactView contactView = (ContactView) o;
        return id == contactView.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
