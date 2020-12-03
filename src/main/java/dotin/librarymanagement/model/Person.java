package dotin.librarymanagement.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "person")
@Entity(name = "Person")
public class Person {
    @Id
    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "person_seq")
    private Long id;

    @Column(name = "cardId", columnDefinition = "varchar2(50)", unique = true)
    private String cardId;

    @Column(name = "name", columnDefinition = "varchar2(30)")
    private String name;

    @Column(name = "family", columnDefinition = "varchar2(30)")
    private String family;

    @Column(name = "birthDate", columnDefinition = "varchar2(20)")
    private Date birthDate;

    @Column(name = "role", columnDefinition = "varchar2(20)")
    private String role;

    @Column(name = "address", columnDefinition = "varchar2(80)")
    private String address;

    @Column(name = "nationalCode", columnDefinition = "varchar2(20)", unique = true, nullable = false)
    private String nationalCode;

    @Column(name = "activation", columnDefinition = "number")
    private int activation;

    @ManyToMany(fetch =FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinTable(name = "LendingModel" , joinColumns = {@JoinColumn (name = "user_Id")},inverseJoinColumns = {@JoinColumn(name = "book_Id")})
    private List<Book> bookList = new ArrayList<>();

    public Person() {
    }

    public Person(String cardId, String name, String family, Date birthDate, String role, String address, String nationalCode, int activation) {
        this.cardId = cardId;
        this.name = name;
        this.family = family;
        this.birthDate = birthDate;
        this.role = role;
        this.address = address;
        this.nationalCode = nationalCode;
        this.activation = activation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public int getActivation() {
        return activation;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}

