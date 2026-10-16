package pl.kfrant.hexagonalarchexample.application.port.out;

import pl.kfrant.hexagonalarchexample.application.domain.model.Account;

import java.time.LocalDateTime;

import static pl.kfrant.hexagonalarchexample.application.domain.model.Account.*;

public interface LoadAccountPort {

    Account loadAccount(AccountId accountId, LocalDateTime baselineDate);
}
