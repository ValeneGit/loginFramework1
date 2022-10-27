package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {

    //fields
    private WebDriver driver;
    private By column_a_box = By.id("column-a");
    private By column_b_box = By.id("column-b");

    //create constructor
    public DragAndDropPage(WebDriver driver){
        this.driver = driver;
    }

    public void DragFrom_boxA_to_boxB(){
        WebElement Element_col_A = driver.findElement(column_a_box);
        WebElement Element_col_B = driver.findElement(column_b_box);

        Actions actions = new Actions(driver);
        actions.dragAndDrop(Element_col_A,Element_col_B)
                .clickAndHold(column_a_box)
                .moveToElement(column_b_box)
                .release()
                .build()
                .perform();

    }
}
