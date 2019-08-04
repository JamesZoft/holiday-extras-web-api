package jamesreed.holidayextrasapitask.user;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    private String email;

    private String firstName;

    private String lastName;

    @Column(name = "created", insertable = false, updatable = false)
    private Instant created;

    private Instant updated;

    public User(Builder b) {
        id = b.id;
        email = b.email;
        firstName = b.firstName;
        lastName = b.lastName;
        updated = b.updated;
    }

    // For hibernate
    private User() {}

    public static class Builder {
        private @NotNull Long id;
        private @NotNull String email;
        private String firstName;
        private String lastName;
        private Instant updated;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withUpdated(Instant updated) {
            this.updated = updated;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Instant getCreated() {
        return created;
    }

    public Instant getUpdated() { return updated; }
}
