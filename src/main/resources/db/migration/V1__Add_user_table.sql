CREATE TABLE `user` (
    id INT NOT NULL IDENTITY PRIMARY KEY,
    email text NOT NULL,
    first_name text,
    last_name text,
    created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)