package pl.kfrant.hexagonalarchexample;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.kfrant.hexagonalarchexample.application.domain.model.Money;
import pl.kfrant.hexagonalarchexample.application.domain.service.MoneyTransferProperties;


@Configuration
@EnableConfigurationProperties(MoneyTransferConfigurationProperties.class)
public class MoneyTransferConfiguration {

    @Bean
    public MoneyTransferProperties moneyTransferProperties(MoneyTransferConfigurationProperties moneyTransferConfigurationProperties){
        return new MoneyTransferProperties(Money.of(moneyTransferConfigurationProperties.getTransferThreshold()));
    }
}
