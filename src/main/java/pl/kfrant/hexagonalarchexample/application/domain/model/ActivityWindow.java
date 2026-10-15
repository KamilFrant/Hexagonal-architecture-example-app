package pl.kfrant.hexagonalarchexample.application.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.NonNull;
import pl.kfrant.hexagonalarchexample.application.domain.model.Account.AccountId;

public class ActivityWindow {

    private List<Activity> activities;

    public LocalDateTime getStartTimestamp() {
        return activities.stream()
                .min(Comparator.comparing(Activity::timestamp))
                .orElseThrow(IllegalStateException::new)
                .timestamp();
    }

    public LocalDateTime getEndTimestamp() {
        return activities.stream()
                .max(Comparator.comparing(Activity::timestamp))
                .orElseThrow(IllegalStateException::new)
                .timestamp();
    }

    public Money calculateBalance(AccountId accountId) {
        Money depositBalance = activities.stream()
                .filter(a -> a.targetAccountId().equals(accountId))
                .map(Activity::money)
                .reduce(Money.ZERO, Money::add);

        Money withdrawalBalance = activities.stream()
                .filter(a -> a.sourceAccountId().equals(accountId))
                .map(Activity::money)
                .reduce(Money.ZERO, Money::add);

        return Money.add(depositBalance, withdrawalBalance.negate());
    }

    public ActivityWindow(@NonNull List<Activity> activities) {
        this.activities = activities;
    }

    public ActivityWindow(@NonNull Activity... activities) {
        this.activities = new ArrayList<>(Arrays.asList(activities));
    }

    public List<Activity> getActivities() {
        return Collections.unmodifiableList(this.activities);
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }
}
