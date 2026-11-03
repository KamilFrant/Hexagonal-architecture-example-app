package pl.kfrant.hexagonalarchexample.application.port.in;

import jakarta.validation.constraints.NotNull;
import pl.kfrant.hexagonalarchexample.application.domain.model.Account.AccountId;
import pl.kfrant.hexagonalarchexample.application.domain.model.Money;

import static pl.kfrant.hexagonalarchexample.common.validation.Validator.validate;

public record SendMoneyCommand(
        @NotNull AccountId sourceAccountId,
        @NotNull AccountId targetAccountId,
        @NotNull @PositiveMoney Money money) {

    public SendMoneyCommand(
            AccountId sourceAccountId,
            AccountId targetAccountId,
            Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        validate(this);
    }
}
