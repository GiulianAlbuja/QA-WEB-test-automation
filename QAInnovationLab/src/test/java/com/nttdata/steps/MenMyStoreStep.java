package com.nttdata.steps;

import com.nttdata.page.MainMyStorePage;
import com.nttdata.page.MenMyStorePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenMyStoreStep {
    WebDriver driver;
    public MenMyStoreStep(WebDriver driver) {
        this.driver = driver;
    }

    public void seleccionarProducto() {
        WebElement botonProducto = driver.findElement(MenMyStorePage.botonProducto);
        botonProducto.click();
    }
}
