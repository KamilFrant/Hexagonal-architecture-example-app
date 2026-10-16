package pl.kfrant.hexagonalarchexample.adapter.out.persistence;

import pl.kfrant.hexagonalarchexample.application.domain.model.Account;
import pl.kfrant.hexagonalarchexample.application.domain.model.Activity;

import java.util.List;

public class AccountMapper {

    //TODO
    public static Account mapToDomainEntity(AccountJpaEntity account, List<ActivityJpaEntity> activities, Long withdrawalBalance, Long depositBalance) {
        return null;
    }

    //TODO
    public static ActivityJpaEntity mapToJpaEntity(Activity activity) {
        return null;
    }
}
