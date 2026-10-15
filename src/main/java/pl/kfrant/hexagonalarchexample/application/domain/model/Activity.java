package pl.kfrant.hexagonalarchexample.application.domain.model;

import java.time.LocalDateTime;

import lombok.NonNull;

public record Activity(ActivityId id, @NonNull Account.AccountId ownerAccountId,
                       @NonNull Account.AccountId sourceAccountId, @NonNull Account.AccountId targetAccountId,
                       @NonNull LocalDateTime timestamp, @NonNull Money money) {

    public Activity(
            @NonNull Account.AccountId ownerAccountId,
            @NonNull Account.AccountId sourceAccountId,
            @NonNull Account.AccountId targetAccountId,
            @NonNull LocalDateTime timestamp,
            @NonNull Money money) {
        this(null, ownerAccountId, sourceAccountId, targetAccountId, timestamp, money);
    }

    public record ActivityId(Long value) {
    }

}
