import { Box, Typography } from "@mui/material";
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
          p: 2,
          m: 1,
          borderRadius: 2,
          cursor: "pointer",
          border: "1px solid",
          borderColor: "divider",
          width: 200,
          textAlign: "center",
          transition: "transform 0.2s",
          "&:hover": {
            transform: "scale(1.05)",
            boxShadow: 3,
          },
        }}
      >
        <img
          className="crypto"
          src={`data:image/png;base64,${props.cryptoSummary.imageData}`}
          alt={props.cryptoSummary.symbol}
        />
        <Typography variant="body1">{props.cryptoSummary.name}</Typography>
        <Typography variant="body1">
          {props.cryptoSummary.latestPrice} USD
        </Typography>
      </Box>
    </Link>
  );
}

export default CryptoSummaryItem;
