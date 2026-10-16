package pl.kfrant.hexagonalarchexample.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kfrant.hexagonalarchexample.application.domain.model.Account;
import pl.kfrant.hexagonalarchexample.application.domain.model.Money;
import pl.kfrant.hexagonalarchexample.application.port.in.SendMoneyCommand;
import pl.kfrant.hexagonalarchexample.application.port.in.SendMoneyUseCase;

@RestController
@RequiredArgsConstructor
public class SendMoneyController {

    //TODO
    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping("/accounts/sendMoney/{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Long amount) {
        SendMoneyCommand command = new SendMoneyCommand(
                new Account.AccountId(sourceAccountId),
                new Account.AccountId(targetAccountId),
                Money.of(amount));
        sendMoneyUseCase.sendMoney(command);
    }

}
