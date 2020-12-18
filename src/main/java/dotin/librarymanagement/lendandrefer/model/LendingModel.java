package dotin.librarymanagement.lendandrefer.model;

import javax.persistence.*;

@Table(name = "LendingModel")
@Entity(name = "LendingModel")
public class LendingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "book_Id", columnDefinition = "number")
    private Long bookId;

    @Column(name = "member_Id", columnDefinition = "number")
    private Long memberId;

    public LendingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
