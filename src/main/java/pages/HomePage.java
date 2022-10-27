package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By formAuthenticationLink = By.linkText("Form Authentication");
    //constructor
    public HomePage (WebDriver driver){
        this.driver = driver;

    }

    //clicking on the form authentication link
    public LoginPage clickFormAuthenticationLink(){
        driver.findElement(formAuthenticationLink).click();
        return new LoginPage(driver);
    }

    public void clickLinkText(String linktext){
        driver.findElement(By.linkText(linktext)).click();
    }

    public  ForgotPasswordPage clickForgotPwd(String linkText){
        clickLinkText(linkText);
        return new ForgotPasswordPage(driver);
    }

    //click on the drag and drop linktext
    public DragAndDropPage ClickOnDragAndDrop(String linktext){
        driver.findElement(By.linkText(linktext)).click();
        return new DragAndDropPage(driver);

    }

}
