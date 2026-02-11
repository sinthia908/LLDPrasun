System design link 
https://www.lldcoding.com/design-lld-paytmphone-wallet-system-machine-coding


User
└── Wallet (lock-protected balance)

Transaction (Template Method)
├── AddMoneyTransaction
├── SendMoneyTransaction
└── RefundTransaction

TransactionManager (Singleton)
├── Idempotency
├── State transitions
└── Concurrency control

PaymentStrategy
├── UPIStrategy
├── CardStrategy
└── NetBankingStrategy

Observer
├── SMSNotifier
├── EmailNotifier
