package pl.kfrant.hexagonalarchexample.adapter.in.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.kfrant.hexagonalarchexample.application.domain.model.Account;
import pl.kfrant.hexagonalarchexample.application.domain.model.Money;
import pl.kfrant.hexagonalarchexample.application.port.in.SendMoneyCommand;
import pl.kfrant.hexagonalarchexample.application.port.in.SendMoneyUseCase;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = SendMoneyController.class)
class SendMoneyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SendMoneyUseCase sendMoneyUseCase;

    @Test
    void testSendMoney() throws Exception {

        mockMvc.perform(post("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}",
                        41L, 42L, 500)
                        .header("Content-Type", "application/json"))
                .andExpect(status().isOk());

        then(sendMoneyUseCase).should()
                .sendMoney(eq(new SendMoneyCommand(
                        new Account.AccountId(41L),
                        new Account.AccountId(42L),
                        Money.of(500L))));
    }

}
