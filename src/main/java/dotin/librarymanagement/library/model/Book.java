package dotin.librarymanagement.library.model;

import dotin.librarymanagement.member.model.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "book")
@Entity(name = "Book")
public class Book {
    @Id
    @SequenceGenerator(name = "book_seq", sequenceName = "book_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "book_seq")
    private Long id;

    @Column(columnDefinition = "varchar2(20)")
    private String bookName;

    @Column(columnDefinition = "varchar2(20)")
    private String isbn;

    @Column(columnDefinition = "varchar2(20)")
    private String authorName;

    @Column(columnDefinition = "varchar2(30)")
    private String classification;

    @Column(columnDefinition = "number")
    private Long status;

    @Column(columnDefinition = "number")
    private Long activation;

    @ManyToMany(mappedBy = "bookList", cascade = CascadeType.PERSIST)
    private List<Member> memberList = new ArrayList<>();

    public void addMember(Member member) {
        memberList.add(member);
        member.getBookList().add(this);
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public Book() {
    }

    public Book(String bookName, String isbn, String authorName, String classification, Long status, Long activation) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.authorName = authorName;
        this.classification = classification;
        this.status = status;
        this.activation = activation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getActivation() {
        return activation;
    }

    public void setActivation(Long activation) {
        this.activation = activation;
    }
}
