package com.interview.practice.ConcreteLockProviders;

import java.util.concurrent.locks.Lock;

public interface LockProvider {

       Lock getLock(String resourceId);

}
