import { useState, ReactNode, useEffect } from "react";
import { AccountContext } from "./AccountContext";
import { getAccountBalance } from "../../api/Account";

type Props = {
  children: ReactNode;
};

export const AccountProvider = ({ children }: Props) => {
  const [accountId, setAccountId] = useState<number | null>(null);
  const [balance, setBalance] = useState<number>(0);

  useEffect(() => {
    if (!accountId) {
      setBalance(0);
      return;
    }

    const fetchBalance = async () => {
      if (!accountId) {
        return;
      }
      const balance = await getAccountBalance(accountId);
      setBalance(balance);
    };

    fetchBalance();
  }, [accountId]);

  return (
    <AccountContext.Provider
      value={{
        accountId,
        balance,
        setAccountId,
        setBalance,
      }}
    >
      {children}
    </AccountContext.Provider>
  );
};
