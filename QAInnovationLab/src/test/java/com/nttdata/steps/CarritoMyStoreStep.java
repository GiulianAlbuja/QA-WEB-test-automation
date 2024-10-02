package com.nttdata.steps;

import com.nttdata.page.CarritoMyStorePage;
import com.nttdata.page.ProductoMyStorePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarritoMyStoreStep {
    WebDriver driver;
    public CarritoMyStoreStep(WebDriver driver) {
        this.driver = driver;
    }

    public void validarTitulo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoMyStorePage.tituloCarrito));
        } catch (TimeoutException e) {
            System.out.println("El elemento no fue encontrado en el tiempo de espera especificado.");
            e.printStackTrace();
        }
    }
}
