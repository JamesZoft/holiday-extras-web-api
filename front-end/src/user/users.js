import React, { useState } from "react";
import useAxios from "axios-hooks";
import User from "./user";

const Users = props => {
  const [{ data, loading, error }, refetch] = useAxios(
    "https://test-spring-boot-jr.herokuapp.com/user"
  );
  const [rows, setRows] = useState(data);

  const refetchSetRows = data => {
    refetch();
    setRows(data);
  };

  if (loading) {
    return <div data-testid="usersDataLoading">Loading...</div>;
  } else if (error) {
    console.log(error);
    return <div data-testid="usersDataError">Error loading users!</div>;
  } else {
    if (!rows) {
      setRows(data);
    }
    console.log("data: " + JSON.stringify(data));
    return (
      <div data-testid="users">
        <div>
          {rows &&
            rows.map((user, i) => {
              return <User user={user} key={i} refetch={refetchSetRows} />;
            })}
        </div>
        <div>
          <button
            onClick={() => {
              setRows(rows => [...rows, {}]);
            }}
          >
            Add User
          </button>
        </div>
      </div>
    );
  }
};

export default Users;
