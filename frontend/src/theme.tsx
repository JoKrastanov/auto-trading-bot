import { createTheme } from "@mui/material/styles";

const theme = createTheme({
  palette: {
    primary: {
      main: "#1976d2", // blue
    },
    secondary: {
      main: "#f50057", // pink
    },
  },
  typography: {
    h1: { fontSize: "2rem", fontWeight: 700 },
    body1: { fontSize: "1rem" },
  },
});

export default theme;
