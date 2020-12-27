package dotin.librarymanagement.identification.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "role")
@Entity(name = "Role")
public class Role {
    @Id
    @SequenceGenerator(name = "role_seq", sequenceName = "role_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "role_seq")
    private Long id;

    @Column(columnDefinition = "varchar2(20)")
    private String role;

    @ManyToMany(mappedBy = "roleList", cascade = CascadeType.PERSIST)
    private List<Person> personList = new ArrayList<>();

    public void addPerson(Person person) {
        personList.add(person);
        person.getRoleList().add(this);
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
