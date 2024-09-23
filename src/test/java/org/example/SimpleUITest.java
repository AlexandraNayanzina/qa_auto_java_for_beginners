package org.example;

import com.codeborne.selenide.*;
import org.example.ui.data.BankAccount;
import org.example.ui.pages.RegisterAccountPage;
import org.example.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.element;

public class SimpleUITest {

    @BeforeAll
    public static void setupTests() {
        Configuration.baseUrl = "https://parabank.parasoft.com";
    }

    @Test
    public void userShouldSeeTheErrorMessageIfEnterOnlyFirstNameLastName() {
        //Prepare the Page
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.openPage();

        //Prepare the data
        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .city(RandomData.randomString())
                .build();

        registerAccountPage.register(bankAccount);
        registerAccountPage.getStreetError().shouldHave(Condition.exactText("Address is required."));

    }
}
