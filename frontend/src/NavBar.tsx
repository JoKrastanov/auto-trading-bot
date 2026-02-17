import { AppBar, Box, Toolbar, Typography, Button } from "@mui/material";
import { Link } from "react-router-dom";
import { useAccount } from "./provider/account/useAccount";

export default function Navbar() {
  const { balance } = useAccount();

  return (
    <AppBar position="static" color="primary">
      <Toolbar sx={{ justifyContent: "center" }}>
        <Box
          sx={{
            display: "flex",
            alignItems: "center",
            justifyContent: "space-between",
            width: "100%",
            maxWidth: 1200,
          }}
        >
          <Box sx={{ display: "flex", gap: 2 }}>
            <Button component={Link} to="/" color="inherit">
              Overview
            </Button>
            <Button component={Link} to="/crypto" color="inherit">
              Cryptos
            </Button>
            <Button component={Link} to="/account" color="inherit">
              Account
            </Button>
            <Button component={Link} to="/" color="inherit">
              Trade Bot
            </Button>
          </Box>
          <Typography variant="subtitle1">
            Balance: ${balance ? balance.toFixed(2) : "Log In To Deposit Funds"}
          </Typography>
        </Box>
      </Toolbar>
    </AppBar>
  );
}
