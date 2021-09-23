package Demo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class stepDefinition {

    WebDriver driver;
    WebDriverWait wait;

    //Variable
    String emailuser ="email";
    String pwduser = "password";
    String buttonLogin ="//form/button";
    String messageError="error_msg";

    @Given("User is on Home Page")
    public void user_is_on_Home_Page(){
        System.setProperty("webdriver.chrome.driver","/Users/jesuseduardomoraperez/Downloads/chromedriver_1");
        driver=new ChromeDriver();

        //Open the browser with the url application
        driver.get("https://todoist.com/es");
    }


    @When("The user provide the wrong credentials")
    public void the_user_provide_the_wrong_credentials() {

        //login click
        WebElement login = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li//a[@href='/users/showlogin']")));
        login.click();

        //Text box for send email
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(emailuser)));
        email.sendKeys("example@example.com");

        //Text box for send pwd
        WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pwduser)));
        pwd.sendKeys("pwd123456");

        //Click Button login
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buttonLogin)));
        button.click();
    }

    @Then("The user should see message wrong email pwd")
    public void the_user_should_message_wrong_email_pwd(){
        //Element Message Validation
        WebElement messageValidation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(messageError)));
        //Obtain Text message
        String CurrenText = messageValidation.getText();
        System.out.println(CurrenText);
        //Current text vs Expected
        Assert.assertEquals(CurrenText,"Wrong email or password.");


    }
}
