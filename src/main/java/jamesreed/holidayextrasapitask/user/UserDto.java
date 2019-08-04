package jamesreed.holidayextrasapitask.user;

import java.time.Instant;

public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Instant created;
    private Instant updated;

    // For spring
    private UserDto() {}

    public UserDto(Builder b) {
        this.id = b.id;
        this.email = b.email;
        this.firstName = b.firstName;
        this.lastName = b.lastName;
        this.created = b.created;
        this.updated = b.updated;
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

    public Instant getUpdated() {
        return updated;
    }

    public static class Builder {
        private Long id;
        private String email;
        private String firstName;
        private String lastName;
        private Instant created;
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

        public Builder withCreated(Instant created) {
            this.created = created;
            return this;
        }

        public Builder withUpdated(Instant updated) {
            this.updated = updated;
            return this;
        }

        public UserDto build() {
            return new UserDto(this);
        }
    }
}
