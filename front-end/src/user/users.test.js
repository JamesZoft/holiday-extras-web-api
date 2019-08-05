import React from "react";
import "@testing-library/react/cleanup-after-each";
import "@testing-library/jest-dom/extend-expect";
import { render, waitForElement } from "@testing-library/react";
import Users from "./users";
import { act } from "react-dom/test-utils";
import axios from "axios";
import MockAdapter from "axios-mock-adapter";

/**
 * Suppress React 16.8 act() warnings globally.
 * The react teams fix won't be out of alpha until 16.9.0.
 */
const consoleError = console.error;
beforeAll(() => {
  jest.spyOn(console, "error").mockImplementation((...args) => {
    if (
      !args[0].includes(
        "Warning: An update to %s inside a test was not wrapped in act"
      )
    ) {
      consoleError(...args);
    }
  });
});

test("shows the loading component when data is still loading", () => {
  const loadingId = "usersDataLoading";

  let users;
  act(() => {
    users = render(<Users />);
  });
  const { getByTestId } = users;

  expect(getByTestId(loadingId)).toBeInTheDocument();
});

test("shows the error component when data loading has errored", async () => {
  const errorId = "usersDataError";
  const mock = new MockAdapter(axios);
  mock.onGet("https://test-spring-boot-jr.herokuapp.com/user").networkErrorOnce();

  let users;
  act(() => {
    users = render(<Users />);
  });
  const { getByTestId } = users;

  const errorElement = await waitForElement(() => getByTestId(errorId));

  expect(errorElement).toBeInTheDocument();
});

test("shows the users component when data has loaded", async () => {
  const usersId = "users";
  const mock = new MockAdapter(axios);
  mock.onGet("https://test-spring-boot-jr.herokuapp.com/user").reply(200, [{}]);
  console.log("LOADED TEST!!!");

  let users;
  act(() => {
    users = render(<Users />);
  });

  const { getByTestId } = users;

  const usersElement = await waitForElement(() => getByTestId(usersId));

  expect(usersElement).toBeInTheDocument();
});
