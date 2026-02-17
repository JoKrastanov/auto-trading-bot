import { Box, Grid, Typography } from "@mui/material";
import { useState, useEffect } from "react";
import { fetchCryptoSummary } from "../api/Crypto";
import { CryptoSummary } from "../models/CryptoSummary";
import CryptoSummaryItem from "./CryptoSummaryItem";

function CryptoSummaryList() {
  const [cryptos, setCryptos] = useState<CryptoSummary[]>([]);

  useEffect(() => {
    fetchCryptoSummary().then((summary) => setCryptos(summary));
  }, []);

  return (
    <Box
      p={2}
      sx={{
        textAlign: "center",
        minHeight: "100vh",
      }}
    >
      <Typography variant="h2" gutterBottom>
        Crypto Dashboard
      </Typography>
      <Grid
        container
        spacing={2}
        sx={{
          display: "grid",
          gridTemplateColumns: "repeat(auto-fit, minmax(300px, 1fr))",
          justifyItems: "center",
          maxWidth: 1400,
          margin: "0 auto",
        }}
      >
        {cryptos.map((crypto) => (
          <CryptoSummaryItem key={crypto.referenceId} cryptoSummary={crypto} />
        ))}
      </Grid>
    </Box>
  );
}

export default CryptoSummaryList;
