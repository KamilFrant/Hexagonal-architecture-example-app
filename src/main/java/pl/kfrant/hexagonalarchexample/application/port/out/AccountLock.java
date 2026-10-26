package pl.kfrant.hexagonalarchexample.application.port.out;

import static pl.kfrant.hexagonalarchexample.application.domain.model.Account.*;

public interface AccountLock {

    void lockAccount(AccountId accountId);

    void releaseAccount(AccountId accountId);

}
