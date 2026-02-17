import {
  Box,
  Typography,
  TextField,
  Button,
  Paper,
  Stack,
} from "@mui/material";
import { useState } from "react";
import { useAccount } from "../provider/account/useAccount";
import { depositBalance, withdrawBalance } from "../api/Account";

export default function AccountDashboard() {
  const [amount, setAmount] = useState<string>("");
  const { accountId, balance, setBalance } = useAccount();

  function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
    const value = e.target.value;

    // allow only numbers + decimals
    if (/^\d*\.?\d*$/.test(value)) {
      setAmount(value);
    }
  }

  async function handleDeposit() {
    if (!accountId) return;
    setBalance(balance + Number(amount));
    await depositBalance(accountId, Number(amount));
  }
  async function handleWithdraw() {
    if (!accountId) return;
    setBalance(balance - Number(amount));
    await withdrawBalance(accountId, Number(amount));
  }

  return (
    <Box
      sx={{
        maxWidth: 500,
        mx: "auto",
        mt: 8,
      }}
    >
      <Paper
        elevation={4}
        sx={{
          p: 4,
          borderRadius: 3,
        }}
      >
        <Typography variant="h4" textAlign="center" mb={3}>
          Account Balance
        </Typography>

        <Typography variant="h5" textAlign="center" fontWeight="bold" mb={4}>
          ${balance.toFixed(2)}
        </Typography>

        <Stack spacing={3}>
          <TextField
            label="Amount"
            value={amount}
            onChange={handleChange}
            inputMode="decimal"
            fullWidth
          />

          <Stack direction="row" spacing={2}>
            <Button
              variant="contained"
              color="success"
              fullWidth
              onClick={handleDeposit}
              disabled={!amount}
            >
              Deposit
            </Button>

            <Button
              variant="outlined"
              color="error"
              fullWidth
              onClick={handleWithdraw}
              disabled={!amount || Number(amount) > balance}
            >
              Withdraw
            </Button>
          </Stack>
        </Stack>
      </Paper>
    </Box>
  );
}
