package customactor.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://accounts.google.com/SignUp?service=mail&continue=https://mail.google.com/mail/")
public class RegisterPage extends PageObject {
    public static Target LAST_NAME = Target.the("last name")
            .located(By.id("lastName"));

    public static Target FIRST_NAME = Target.the("first name")
            .located(By.id("firstName"));

    public static Target USERNAME = Target.the("username")
            .located(By.id("username"));

    public static Target PASSWORD = Target.the("password")
            .located(By.name("Passwd"));

    public static Target CONFIRM_PASSWORD = Target.the("confirm password")
            .located(By.name("ConfirmPasswd"));
}
