package com.nttdata.steps;

import com.nttdata.page.LoginMyStorePage;
import com.nttdata.page.MainMyStorePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginMyStoreStep {
    WebDriver driver;
    public LoginMyStoreStep(WebDriver driver) {
        this.driver = driver;
    }

    public void escribirUsuario(String usuario) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginMyStorePage.userInput));

        WebElement usuarioInput = driver.findElement(LoginMyStorePage.userInput);
        usuarioInput.sendKeys(usuario);
    }

    public void escribirClave(String clave) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(LoginMyStorePage.passwordInput));

        WebElement passwordInput = driver.findElement(LoginMyStorePage.passwordInput);
        passwordInput.sendKeys(clave);
    }

    public void clickSubmit() {
        WebElement boton = driver.findElement(LoginMyStorePage.submitBoton);
        boton.click();
    }


    public void validarlogueo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement sesionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MainMyStorePage.sesion));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(MainMyStorePage.sesion));
            String textoSesion = sesionElement.getText();

            String cadenaLimpia = textoSesion.replaceAll("\\?", "").trim();
            if (!cadenaLimpia.equals("Cerrar sesión")) {
                // Lanza una excepción si el texto no es "Cerrar sesión"
                throw new Exception("El texto del botón de sesión no es 'Cerrar sesión'. Es: " + cadenaLimpia);
            } else {
                System.out.println("El logueo fue exitoso. Se encontró el texto 'Cerrar sesión'.");
            }

        } catch (TimeoutException e) {
            System.out.println("El elemento no fue encontrado en el tiempo de espera especificado.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
