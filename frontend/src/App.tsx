import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import CryptoSummaryList from "./summary/CryptoSummaryList";
import CryptoDetailsPage from "./details/CryptoDetailsPage";
import AccountDetails from "./account/AccountDetails";
import Overview from "./Overview";
import { AccountProvider } from "./provider/account/AccountProvider";
import NavBar from "./NavBar";

function App() {
  return (
    <AccountProvider>
      <BrowserRouter>
        <NavBar />
        <Routes>
          <Route path="/" element={<Overview />} />
          <Route path="/crypto" element={<CryptoSummaryList />} />
          <Route path="/crypto/:referenceId" element={<CryptoDetailsPage />} />
          <Route path="/account" element={<AccountDetails />} />
        </Routes>
      </BrowserRouter>
    </AccountProvider>
  );
}

export default App;
