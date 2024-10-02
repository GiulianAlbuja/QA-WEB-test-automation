package com.nttdata.steps;

import com.nttdata.page.ProductoMyStorePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductoMyStoreStep {
    WebDriver driver;
    public ProductoMyStoreStep(WebDriver driver) {
        this.driver = driver;
    }

    public void aumentarCantidadProductoEnUno() {
        WebElement botonAumentar = driver.findElement(ProductoMyStorePage.botonAumentar);
        botonAumentar.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ProductoMyStorePage.botonAumentar));
    }

    public void agregoAlCarrito() {
        WebElement botonAgregarCarrito = driver.findElement(ProductoMyStorePage.botonAgregarCarrito);
        botonAgregarCarrito.click();
    }

    public void validarProductoAgregado() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ProductoMyStorePage.popUpConfirmacion));
        } catch (TimeoutException e) {
            System.out.println("El elemento no fue encontrado en el tiempo de espera especificado.");
            e.printStackTrace();
        }


    }

    public void validarMontoTotalCalculado() {
    }

    public void finalizoCompra() {
        WebElement botonFinalizar = driver.findElement(ProductoMyStorePage.botonFinalizar);
        botonFinalizar.click();
    }
}
