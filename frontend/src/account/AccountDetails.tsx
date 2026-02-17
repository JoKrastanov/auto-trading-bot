import { Box, Typography, Button } from "@mui/material";
import { useEffect } from "react";
import AddCircleIcon from "@mui/icons-material/AddCircle";
import { createNewAccount } from "../api/Account";
import AccountDashboard from "./AccountDashboard";
import { useAccount } from "../provider/account/useAccount";

function AccountDetails() {
    const { accountId, setAccountId } = useAccount();

  function createAccount() {
    createNewAccount().then((newAccId) => {
      setAccountId(newAccId);
      localStorage.setItem("accountId", newAccId.toString());
    });
  }

  useEffect(() => {
    const stored = localStorage.getItem("accountId");
    if (stored) {
      setAccountId(Number(stored));
    }
  }, []);

  return (
    <Box
      sx={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
      }}
    >
      <Typography variant="h2" gutterBottom>
        Account Details
      </Typography>
      {accountId ? (
        <AccountDashboard />
      ) : (
        <Button
          sx={{
            display: "flex",
            flexDirection: "row",
            alignItems: "center",
            justifyContent: "center",
            p: 2,
            gap: 2,
            color: "white",
          }}
          onClick={createAccount}
        >
          <AddCircleIcon fontSize="large" color="success" />
          <Typography variant="h4">Create Account</Typography>
        </Button>
      )}
    </Box>
  );
}

export default AccountDetails;
