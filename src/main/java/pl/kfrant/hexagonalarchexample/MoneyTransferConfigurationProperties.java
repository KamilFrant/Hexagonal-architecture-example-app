package pl.kfrant.hexagonalarchexample;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "buckpal")
public class MoneyTransferConfigurationProperties {
    private long transferThreshold = Long.MAX_VALUE;
}
