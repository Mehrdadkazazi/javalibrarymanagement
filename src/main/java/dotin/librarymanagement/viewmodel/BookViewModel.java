package dotin.librarymanagement.viewmodel;

import dotin.librarymanagement.general.model.ResponseObject;

public class BookViewModel extends ResponseObject {

    private Long id;

    private String bookName;

    private String isbn;

    private String authorName;

    private String classification;

    private String status;

    private Long activation;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getActivation() {
        return activation;
    }

    public void setActivation(Long activation) {
        this.activation = activation;
    }
}
