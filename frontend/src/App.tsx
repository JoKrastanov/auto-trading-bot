import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./App.css";
import CryptoSummaryList from "./summary/CryptoSummaryList";
import CryptoDetailsPage from "./details/CryptoDetailsPage";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<CryptoSummaryList />} />
        <Route path="/crypto/:referenceId" element={<CryptoDetailsPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
