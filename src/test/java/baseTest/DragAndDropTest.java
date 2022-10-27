package baseTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTests{

    @Test
    public void DragFrom_boxA_to_boxB(){
        DragAndDropPage dragAndDropPage = homePage.ClickOnDragAndDrop("Drag and Drop");
        dragAndDropPage.DragFrom_boxA_to_boxB();

    }

}
