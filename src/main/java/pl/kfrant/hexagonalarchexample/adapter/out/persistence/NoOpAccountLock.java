package pl.kfrant.hexagonalarchexample.adapter.out.persistence;

import org.springframework.stereotype.Component;
import pl.kfrant.hexagonalarchexample.application.domain.model.Account;
import pl.kfrant.hexagonalarchexample.application.port.out.AccountLock;

@Component
class NoOpAccountLock implements AccountLock {

    @Override
    public void lockAccount(Account.AccountId accountId) {
        // do nothing
    }

    @Override
    public void releaseAccount(Account.AccountId accountId) {
        // do nothing
    }

}
