package pl.kfrant.hexagonalarchexample.application.port.out;

import pl.kfrant.hexagonalarchexample.application.domain.model.Account;

public interface UpdateAccountStatePort {

    void updateActivities(Account account);
}
