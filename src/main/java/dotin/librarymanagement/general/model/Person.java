package dotin.librarymanagement.general.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Table(name = "person")
@Entity(name = "Person")
public class Person {
    @Id
    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "person_seq")
    private Long id;

    @Column(columnDefinition = "varchar2(20)")
    private String username;

    @Column(columnDefinition = "varchar2(50)")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "PersonRole", joinColumns = {@JoinColumn(name = "person_Id")}, inverseJoinColumns = {@JoinColumn(name = "role_Id")})
    private List<Role> roleList = new ArrayList<>();

    public Person() {
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
