import React, { useState } from "react";
import styled from "styled-components";
import axios from "axios";

const Input = styled.input`
    margin-left: 5px;
  `,
  Span = styled.span`
    margin-right: 10px;
  `;

const submitUser = (user, refetch) => {
  axios.post("https://test-spring-boot-jr.herokuapp.com/user", user).then(() => refetch());
};

const deleteUser = (user, refetch) => {
  axios.delete(`https://test-spring-boot-jr.herokuapp.com/user/${user.id}`).then(() => refetch());
};

const User = props => {
  const [user, setUser] = useState(props.user);

  return (
    <div>
      <Span>
        <label htmlFor="email">Email:</label>
        <Input
          name="email"
          type="email"
          value={user.email}
          onChange={e => setUser({ ...user, email: e.target.value })}
        />
      </Span>
      <Span>
        <label htmlFor="firstName">First Name:</label>
        <Input
          name="firstName"
          type="firstName"
          value={user.firstName}
          onChange={e => setUser({ ...user, firstName: e.target.value })}
        />
      </Span>
      <Span>
        <label htmlFor="lastName">Last Name:</label>
        <Input
          name="lastName"
          type="lastName"
          value={user.lastName}
          onChange={e => setUser({ ...user, lastName: e.target.value })}
        />
      </Span>
      <Span>Created: {user.created}</Span>
      <Span>Updated: {user.updated}</Span>
      <Span>
        <button type="submit" onClick={() => submitUser(user, props.refetch)}>
          Submit
        </button>
      </Span>
      <Span>
        <button type="submit" onClick={() => deleteUser(user, props.refetch)}>
          Delete
        </button>
      </Span>
    </div>
  );
};

export default User;
