package dotin.librarymanagement.viewmodel;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

public class PersonViewModel {


    @Digits(integer = 100, fraction = 0, message = "Max number validation is validated")
    private Long id;

    @Size(max = 100, message = "Max number validation is validated")
    private String username;

    @Size(max = 100, message = "Max number validation is validated")
    private String password;

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
}
