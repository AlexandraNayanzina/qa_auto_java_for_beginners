package org.example.ui.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.element;
import lombok.Getter;
import org.example.ui.data.BankAccount;

@Getter
public class RegisterAccountPage {

    // Elements
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));
    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));
    private SelenideElement registerBtn = element(Selectors.byValue("Register"));

    // Errors
    private SelenideElement streetError = element(Selectors.byId("customer.address.street.errors"));


    public void openPage() {
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount) {
        firstNameInput.sendKeys(bankAccount.getFirstName());
        lastNameInput.sendKeys(bankAccount.getLastName());
        registerBtn.click();
    }

}
