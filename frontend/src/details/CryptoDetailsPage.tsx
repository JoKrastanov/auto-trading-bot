import { Box, Card, CardContent, Stack, Typography } from "@mui/material";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { fetchCryptoById } from "../api/Crypto";
import { CryptoDetail } from "../models/CryptoDetail";
import PercentChange from "./PercentChange";

function CryptoDetailsPage() {
  const { referenceId } = useParams();
  const [crypto, setCrypto] = useState<CryptoDetail | null>(null);

  useEffect(() => {
    fetchCryptoById(referenceId ?? "").then((details) => setCrypto(details));
  }, []);

  if (!crypto) {
    return <>Loading...</>;
  }
  return (
    <Card sx={{ maxWidth: 600, mx: "auto", mt: 4 }}>
      <CardContent>
        <Stack spacing={3}>
          <Stack direction="row" spacing={2} alignItems="center">
            <Box
              component="img"
              src={`data:image/png;base64,${crypto.imageData}`}
              sx={{ width: 64, height: 64 }}
            />
            <Box>
              <Typography variant="h5">{crypto.name}</Typography>
              <Typography color="text.secondary">{crypto.symbol}</Typography>
            </Box>
          </Stack>

          <Box>
            <Typography variant="h4">
              ${crypto.latestPriceUsd}
            </Typography>
          </Box>

          <Stack direction="row" spacing={4} justifyContent="center">
            <Box>
              <Typography variant="caption">1h</Typography>
              <PercentChange value={crypto.percentagePriceChangeLastHour} />
            </Box>
            <Box>
              <Typography variant="caption">24h</Typography>
              <PercentChange value={crypto.percentagePriceChangeLastDay} />
            </Box>
            <Box>
              <Typography variant="caption">7d</Typography>
              <PercentChange value={crypto.percentagePriceChangeLastWeek} />
            </Box>
          </Stack>

          <Stack spacing={1}>
            <Typography>
              Market Cap: ${crypto.marketCapUsd.toLocaleString()}
            </Typography>
            <Typography>
              Circulating Supply: {crypto.circulatingSupply.toLocaleString()}
            </Typography>
            <Typography>
              Max Supply: {crypto.maxSupply?.toLocaleString() || "N/A"}
            </Typography>
          </Stack>
        </Stack>
      </CardContent>
    </Card>
  );
}

export default CryptoDetailsPage;
