package jamesreed.holidayextrasapitask.user;

import java.time.Instant;

public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Instant created;

    // For spring
    private UserDto() {}

    public UserDto(Builder b) {
        this.id = b.id;
        this.email = b.email;
        this.firstName = b.firstName;
        this.lastName = b.lastName;
        this.created = b.created;
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

    public static class Builder {
        private Long id;
        private String email;
        private String firstName;
        private String lastName;
        private Instant created;

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

        public Builder withCreated(Instant created) {
            this.created = created;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", created=" + created +
                '}';
    }
}
