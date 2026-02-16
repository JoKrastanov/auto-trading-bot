import { CryptoSummary } from "../models/CryptoSummary";

const API_URL = import.meta.env.VITE_API_ENDPOINT;

export async function fetchCryptoSummary(): Promise<CryptoSummary[]> {
    const res = await fetch(`${API_URL}/crypto/currencies`);
    return res.json();
}
