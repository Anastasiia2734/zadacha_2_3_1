package web.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pol")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Size(min = 1, max = 20, message = "first_name должно содежать от 1 до 20 символов")
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Size(min = 1, max = 20, message = "last_name должно содержать от 1 до 20 символов")
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    public User() {

    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
