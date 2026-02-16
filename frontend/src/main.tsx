import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import theme from "./theme.tsx";
import "./index.css";
import App from "./App.tsx";
import { ThemeProvider } from "@emotion/react";

createRoot(document.getElementById("root")!).render(
  <ThemeProvider theme={theme}>
    <StrictMode>
      <App />
    </StrictMode>
  </ThemeProvider>,
);
