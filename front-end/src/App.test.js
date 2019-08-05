import React from "react";
import ReactDOM from "react-dom";
import App from "./App";
import { act } from "react-dom/test-utils";
import "@testing-library/react/cleanup-after-each";
import "@testing-library/jest-dom/extend-expect";
import { render } from "@testing-library/react";

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

test("renders without crashing", () => {
  const div = document.createElement("div");
  act(() => {
    render(<App />, div);
  });
});
