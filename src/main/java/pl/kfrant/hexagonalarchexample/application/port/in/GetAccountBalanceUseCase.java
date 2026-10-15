package pl.kfrant.hexagonalarchexample.application.port.in;

import pl.kfrant.hexagonalarchexample.application.domain.model.Money;

import static pl.kfrant.hexagonalarchexample.application.domain.model.Account.*;

public interface GetAccountBalanceUseCase {

    Money getAccountBalance(GetAccountBalanceQuery query);

    record GetAccountBalanceQuery(AccountId accountId) {
    }
}
