import { Stack, Typography } from "@mui/material";
import TrendingUpIcon from "@mui/icons-material/TrendingUp";
import TrendingDownIcon from "@mui/icons-material/TrendingDown";

const formatPercent = (value: number) => Math.round(value * 100) / 100;

interface PercentChangeProps {
  value: number;
}

function PercentChange(props: PercentChangeProps) {
  const positive = props.value >= 0;

  return (
    <Stack direction="row" spacing={0.5} alignItems="center">
      {positive ? (
        <TrendingUpIcon fontSize="small" color="success" />
      ) : (
        <TrendingDownIcon fontSize="small" color="error" />
      )}
      <Typography color={positive ? "success.main" : "error.main"}>
        {formatPercent(props.value)}%
      </Typography>
    </Stack>
  );
}

export default PercentChange;
