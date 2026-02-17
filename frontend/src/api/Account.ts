const API_URL = import.meta.env.VITE_API_ENDPOINT;

export async function createNewAccount(): Promise<number> {
    const res = await fetch(`${API_URL}/account/create`, {
        method: "POST"
    });
    return res.json();
}


export async function getAccountBalance(id: number): Promise<number> {
    const res = await fetch(`${API_URL}/account/${id}/balance`, {
        method: "GET"
    });
    return res.json();
}

export async function depositBalance(id: number, amount: number) {
    const res = await fetch(`${API_URL}/account/${id}/deposit`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ amount }),
    });
    return res.json();
}


export async function withdrawBalance(id: number, amount: number) {
    const res = await fetch(`${API_URL}/account/${id}/withdraw`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({ amount }),
    });
    return res.json();
}