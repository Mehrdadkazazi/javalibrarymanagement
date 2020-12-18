package dotin.librarymanagement.general.model;

import javax.persistence.*;

@Table(name = "userRole")
@Entity(name = "UserRole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_Id", columnDefinition = "number")
    private Long userId;

    @Column(name = "role_Id", columnDefinition = "number")
    private Long roleId;

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
