package customactor.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetAccountInformation implements Ability {
    private final String firstName;
    private final String lastName;
    private final String account;
    private final String password;

    public static GetAccountInformation fromConfig()
    {
        // create reader object
        FileReader reader = null;
        Properties properties = null;
        try {
            reader = new FileReader("src/test/resources/UserInfo.properties");
            // crate properties object
            properties = new Properties();
            properties.load(reader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new GetAccountInformation(
                properties.getProperty("FirstName"),
                properties.getProperty("LastName"),
                properties.getProperty("Account"),
                properties.getProperty("Password"));
    }

    public static GetAccountInformation with(
            String firstName,
            String lastName,
            String account,
            String password
    )
    {
        return new GetAccountInformation(firstName, lastName, account, password);
    }

    public static GetAccountInformation as(Actor actor)
    {
        return actor.abilityTo(GetAccountInformation.class);
    }

    public String firstName()
    {
        return this.firstName;
    }

    public String lastName()
    {
        return this.lastName;
    }

    public String account()
    {
        return this.account;
    }

    public String password()
    {
        return this.password;
    }

    public GetAccountInformation(
            String firstName,
            String lastName,
            String account,
            String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.password = password;
    }
}
