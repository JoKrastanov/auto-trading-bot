export interface CryptoDetail {
  referenceId: string;
  name: string;
  symbol: string;
  maxSupply: number;
  circulatingSupply: number;
  marketCapUsd: number;
  latestPriceUsd: number;
  percentagePriceChangeLastHour: number;
  percentagePriceChangeLastDay: number;
  percentagePriceChangeLastWeek: number;
  imageData: string;
}