Design a rate-limiting library that supports the following advanced requirements:

Granular Limits: Support different rate limits for different API endpoints (e.g., /login has 5 requests/min, while /search has 100 requests/min).
Multi-Period Constraints: Support multiple time windows for the same API (e.g., 10 requests per minute AND 500 requests per day).
Combined/Aggregate Limits: Support rate limits that apply to a group of APIs combined (e.g., the total requests to /upload and /download together should not exceed 50 per hour).



Flow >> 

Client Request
↓
RequestContext
↓
RateLimiter.allow()
↓
RuleResolver.resolve()
↓
List<Rules>
↓
For each Rule:
→ Strategy.allow()
→ CounterStore.increment()
↓
Any fail → Exception
All pass → Allowed


ratelimiter/
├── pom.xml
└── src/
└── main/
├── java/
│   └── com/
│       └── example/
│           └── ratelimiter/
│
│               ├── api/
│               │   └── RateLimiter.java
│
│               ├── model/
│               │   ├── RequestContext.java
│               │   ├── RateLimitRule.java
│               │   ├── Group.java
│               │   └── LimitType.java
│
│               ├── resolver/
│               │   └── RuleResolver.java
│
│               ├── strategy/
│               │   ├── CounterStrategy.java
│               │   └── FixedWindowStrategy.java
│
│               ├── store/
│               │   ├── CounterStore.java
│               │   └── InMemoryCounterStore.java
│
│               ├── exception/
│               │   └── RateLimitExceededException.java
│
│               ├── util/
│               │   └── KeyBuilder.java
│
│               └── Main.java
│
└── resources/
└── logback.xml


“I designed the system around policy evaluation, where each request is validated against multiple independent constraints. The system is modularized into resolution, evaluation, and storage layers to allow independent scaling and evolution.