# bank-account-manager

A console bank-account manager: creates a savings and a cheque account, then a
menu to deposit, withdraw (with overdraft protection), apply a monthly fee and
print balances.

> Built within my first ~4–5 months of learning Java (a coding course). Kept as a record of progress, not as polished production code.

## Run
```bash
find src -name '*.java' | xargs javac -d out
java -cp out ManageAccounts
```

## Fixes
- Made the second account's type and its menu label consistent.
- Removed an empty-statement `;` bug in `applyMonthlyFee`.

## Note
Each account reads from its own `Scanner`; feeding it rapid piped input without
pauses can swallow lines. Interactive use is unaffected.
