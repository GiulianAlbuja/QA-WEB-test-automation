package com.nttdata.steps;

import com.nttdata.page.LoginMyStorePage;
import com.nttdata.page.MainMyStorePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainMyStoreStep {
    WebDriver driver;
    public MainMyStoreStep(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCategoria(String categoria) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement categoriaElemento = wait.until(ExpectedConditions.visibilityOfElementLocated(MainMyStorePage.categoriaBoton));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MainMyStorePage.categoriaBoton));

            String texto = categoriaElemento.getText();

            System.out.println("Texto del elemento: " + texto + "+++++++++++++++++++" + categoriaElemento);

            if (!texto.equals(categoria)) {
                throw new Exception("Categoria incorrecta");
            } else {
                System.out.println("Categoría correcta.");
            }

        } catch (TimeoutException e) {
            System.out.println("El elemento no fue encontrado en el tiempo de espera especificado.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebElement botonCategoria = driver.findElement(MainMyStorePage.categoriaBoton);
        botonCategoria.click();
    }

    public void clickSubCategoria(String subcategoria) {

        WebElement botonSubcategoria = driver.findElement(MainMyStorePage.subcategoriaBoton);
        botonSubcategoria.click();
    }
}
