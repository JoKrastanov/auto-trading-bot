import { Box, Grid, Typography } from "@mui/material";
import PersonIcon from "@mui/icons-material/Person";
import ShowChartIcon from "@mui/icons-material/ShowChart";
import PsychologyIcon from "@mui/icons-material/Psychology";
import { Link } from "react-router-dom";

function Overview() {
  return (
    <Grid
      container
      spacing={2}
      sx={{
        display: "grid",
        gridTemplateColumns: "repeat(auto-fit, minmax(300px, 1fr))",
        justifyItems: "center",
        alignItems: "center",
        maxWidth: 1200,
        height: "100%",
        margin: "0 auto",
      }}
    >
      <Link to="/account">
        <Box>
          <PersonIcon sx={{ fontSize: 160 }} />
          <Typography variant="h4">Account</Typography>
        </Box>
      </Link>
      <Link to="/crypto">
        <Box>
          <ShowChartIcon sx={{ fontSize: 160 }} />
          <Typography variant="h4">Coins</Typography>
        </Box>
      </Link>
      <Link to="/">
        <Box>
          <PsychologyIcon sx={{ fontSize: 160 }} />
          <Typography variant="h4">Trade Bot</Typography>
        </Box>
      </Link>
    </Grid>
  );
}

export default Overview;
