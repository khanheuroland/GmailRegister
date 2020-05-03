package customactor.tasks;

import customactor.abilities.GetAccountInformation;
import customactor.ui.RegisterPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class Register implements Task {
    @Step("Search for #searchTerm")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(accountInformation(actor).lastName()).into(RegisterPage.LAST_NAME),
                Enter.theValue(accountInformation(actor).firstName()).into(RegisterPage.FIRST_NAME),
                Enter.theValue(accountInformation(actor).account()).into(RegisterPage.USERNAME),
                Enter.theValue(accountInformation(actor).password()).into(RegisterPage.PASSWORD),
                Enter.theValue(accountInformation(actor).password()).into(RegisterPage.CONFIRM_PASSWORD)
                .thenHit(ENTER)
        );
    }

    public static Register withUserInfo() {
        return instrumented(Register.class);
    }

    private GetAccountInformation accountInformation(Actor actor)
    {
        return GetAccountInformation.as(actor);
    }
}
