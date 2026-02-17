import { createContext } from "react";

type AccountContextType = {
  accountId: number | null;
  balance: number;
  setAccountId: (id: number | null) => void;
  setBalance: (balance: number) => void;
};

export const AccountContext = createContext<AccountContextType | undefined>(
  undefined,
);
