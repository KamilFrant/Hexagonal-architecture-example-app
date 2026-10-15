package pl.kfrant.hexagonalarchexample.application.domain.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import pl.kfrant.hexagonalarchexample.application.port.in.SendMoneyCommand;
import pl.kfrant.hexagonalarchexample.application.port.in.SendMoneyUseCase;
import pl.kfrant.hexagonalarchexample.application.port.out.LoadAccountPort;
import pl.kfrant.hexagonalarchexample.application.port.out.UpdateAccountStatePort;

@RequiredArgsConstructor
@Transactional
public class SendMoneyService implements SendMoneyUseCase {
    private final LoadAccountPort loadAccountPort;
    private final UpdateAccountStatePort updateAccountStatePort;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        return false;
    }
}
