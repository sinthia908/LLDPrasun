# BNPL LLD - Java 17

## Run
From this directory:
    mvn compile
    java -cp target/classes com.interview.bnpl.app.BNPLApplication

The project is dependency-free and uses in-memory repositories plus a mock payment gateway.

## Patterns
- Strategy: repayment plan implementations
- Factory: RepaymentPlanFactory
- State: LoanState implementations
- Adapter: PaymentGateway abstraction and MockPaymentGateway
- Repository: repository interfaces and in-memory implementations

## Scope / production caveats
This is an LLD interview implementation, not production lending software. The in-memory repositories do not provide durable transactions, distributed locking, or true cross-process idempotency. A production version should use database transactions, unique constraints, a durable payment state machine, provider webhook/reconciliation handling, a ledger, and an outbox. The purchase method models credit booking and loan creation; merchant funding and lender integrations are intentionally abstracted.
