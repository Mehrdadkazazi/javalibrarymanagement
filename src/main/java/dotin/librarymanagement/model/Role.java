//package ir.dotin.educationProject.libraryManagement.model.model;
//
//import javax.persistence.*;
//import java.util.List;
//import java.util.Set;
//
//@Entity(name = "Role")
//@Table(name = "role")
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(columnDefinition = "varchar2(20)")
//    private String role;
//    @ManyToMany(mappedBy = "roles")
//    private List<Person> persons;
//
//    public Role() {
//    }
//
//    public Role(Long id, String name, Set<User> users) {
//        this.id = id;
//        this.name = name;
//        this.users = users;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
//}
