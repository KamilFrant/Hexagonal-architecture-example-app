package pl.kfrant.hexagonalarchexample.adapter.out.persistence;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import pl.kfrant.hexagonalarchexample.application.domain.model.Account;
import pl.kfrant.hexagonalarchexample.application.domain.model.ActivityWindow;
import pl.kfrant.hexagonalarchexample.application.domain.model.Money;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.kfrant.hexagonalarchexample.application.domain.model.Account.*;
import static pl.kfrant.hexagonalarchexample.common.AccountTestData.defaultAccount;
import static pl.kfrant.hexagonalarchexample.common.ActivityTestData.defaultActivity;

@DataJpaTest
@Import({AccountPersistenceAdapter.class, AccountMapper.class})
class AccountPersistenceAdapterTest {

    @Autowired
    private AccountPersistenceAdapter adapterUnderTest;

    @Autowired
    private ActivityRepository activityRepository;

    @Test
    @Sql("AccountPersistenceAdapterTest.sql")
    void loadsAccount() {
        Account account = adapterUnderTest.loadAccount(new AccountId(1L), LocalDateTime.of(2018, 8, 10, 0, 0));

        assertThat(account.getActivityWindow().getActivities()).hasSize(2);
        assertThat(account.calculateBalance()).isEqualTo(Money.of(500));
    }

    @Test
    void updatesActivities() {
        Account account = defaultAccount()
                .withBaselineBalance(Money.of(555L))
                .withActivityWindow(new ActivityWindow(
                        defaultActivity()
                                .withId(null)
                                .withMoney(Money.of(1L)).build()))
                .build();

        adapterUnderTest.updateActivities(account);

        assertThat(activityRepository.count()).isEqualTo(1);

        ActivityJpaEntity savedActivity = activityRepository.findAll().getFirst();
        assertThat(savedActivity.getAmount()).isEqualTo(1L);
    }

}
