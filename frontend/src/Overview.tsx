import { Box, Grid, Paper, Typography } from "@mui/material";
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
        <Box
          sx={{
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
              borderRadius: 3,
            }}
          >
            <PersonIcon sx={{ fontSize: 160 }} />
            <Typography variant="h4">Account</Typography>
          </Paper>
        </Box>
      </Link>
      <Link to="/crypto">
        <Box
          sx={{
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
              borderRadius: 3,
            }}
          >
            <ShowChartIcon sx={{ fontSize: 160 }} />
            <Typography variant="h4">Coins</Typography>
          </Paper>
        </Box>
      </Link>
      <Link to="/">
        <Box
          sx={{
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
              borderRadius: 3,
            }}
          >
            <PsychologyIcon sx={{ fontSize: 160 }} />
            <Typography variant="h4">Trade Bot</Typography>
          </Paper>
        </Box>
      </Link>
    </Grid>
  );
}

export default Overview;
