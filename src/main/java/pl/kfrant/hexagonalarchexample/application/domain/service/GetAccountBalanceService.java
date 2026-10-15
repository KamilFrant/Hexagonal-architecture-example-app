package pl.kfrant.hexagonalarchexample.application.domain.service;

import lombok.RequiredArgsConstructor;
import pl.kfrant.hexagonalarchexample.application.domain.model.Money;
import pl.kfrant.hexagonalarchexample.application.port.in.GetAccountBalanceUseCase;
import pl.kfrant.hexagonalarchexample.application.port.out.LoadAccountPort;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class GetAccountBalanceService {

    private final LoadAccountPort loadAccountPort;

    public Money getAccountBalance(GetAccountBalanceUseCase.GetAccountBalanceQuery query){
//        return loadAccountPort.loadAccount(query.accountId(), LocalDateTime.now())
//                .calculateBalance();
        return Money.ZERO;
    }
}
