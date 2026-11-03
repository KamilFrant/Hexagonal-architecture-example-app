package pl.kfrant.hexagonalarchexample.application.domain.service;

import lombok.RequiredArgsConstructor;
import pl.kfrant.hexagonalarchexample.application.domain.model.Money;
import pl.kfrant.hexagonalarchexample.application.port.in.GetAccountBalanceUseCase;
import pl.kfrant.hexagonalarchexample.application.port.out.LoadAccountPort;

import java.time.LocalDateTime;

@RequiredArgsConstructor
class GetAccountBalanceService implements GetAccountBalanceUseCase{

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(GetAccountBalanceQuery query) {
        return loadAccountPort.loadAccount(query.accountId(), LocalDateTime.now())
                .calculateBalance();
    }
}
