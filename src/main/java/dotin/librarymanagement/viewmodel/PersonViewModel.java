package dotin.librarymanagement.viewmodel;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class PersonViewModel {

    @Digits(integer = 10, fraction = 0 , message = "Max number validation is validated")
    private Long id;

    @NotNull
    @Size(max = 100 , message = "Max number validation is validated")
    private String cardId;

    @Size(max = 100 , message = "Max number validation is validated")
    private String name;

    @Size(max = 100 , message = "Max number validation is validated")
    private String family;

    @Size(max = 20 , message = "Max number validation is validated")
    private Date birthDate;

    @Size(max = 20 , message = "Max number validation is validated")
    private String role;

    @Size(max = 1000 , message = "Max number validation is validated")
    private String address;

    @Size(max = 10 , message = "Max number validation is validated")
    private String nationalCode;

    @Size(max = 2 , message = "Max number validation is validated")
    private int activation;

    public PersonViewModel() {
    }

    public PersonViewModel(@Digits(integer = 10, fraction = 0, message = "Max number validation is validated") Long id, @NotNull @Size(max = 100, message = "Max number validation is validated") String cardId, @Size(max = 100, message = "Max number validation is validated") String name, @Size(max = 100, message = "Max number validation is validated") String family, @Size(max = 20, message = "Max number validation is validated") Date birthDate, @Size(max = 20, message = "Max number validation is validated") String role, @Size(max = 1000, message = "Max number validation is validated") String address, @Size(max = 10, message = "Max number validation is validated") String nationalCode, @Size(max = 2, message = "Max number validation is validated") int activation) {
        this.id = id;
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
}
