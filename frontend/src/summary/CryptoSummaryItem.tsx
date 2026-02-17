import { Box, Paper, Typography } from "@mui/material";
import { CryptoSummary } from "../models/CryptoSummary";
import { Link } from "react-router-dom";

interface CryptoSummaryItemProps {
  cryptoSummary: CryptoSummary;
}

function CryptoSummaryItem(props: CryptoSummaryItemProps) {
  return (
    <Link to={`/crypto/${props.cryptoSummary.referenceId}`}>
      <Box
        sx={{
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
          m: 1,
          cursor: "pointer",
          width: 200,
          textAlign: "center",
          transition: "transform 0.2s",
          "&:hover": {
            transform: "scale(1.05)",
            boxShadow: 3,
          },
        }}
      >
        <Paper
          elevation={4}
          sx={{
            p: 6,
            borderRadius: 2,
          }}
        >
          <img
            className="crypto"
            src={`data:image/png;base64,${props.cryptoSummary.imageData}`}
            alt={props.cryptoSummary.symbol}
          />
          <Typography variant="body1">{props.cryptoSummary.name}</Typography>
          <Typography variant="body1">
            ${props.cryptoSummary.latestPrice}
          </Typography>
        </Paper>
      </Box>
    </Link>
  );
}

export default CryptoSummaryItem;
