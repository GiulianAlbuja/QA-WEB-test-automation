package com.nttdata.page;

import org.openqa.selenium.By;

public class ProductoMyStorePage {
    public static By botonAumentar = By.xpath("//span/button[@class='btn btn-touchspin js-touchspin bootstrap-touchspin-up']");
    public static By botonAgregarCarrito = By.xpath("//div/button[@class='btn btn-primary add-to-cart']");
    public static By popUpConfirmacion = By.xpath("//div/h4[contains(text(), \"Producto añadido correctamente a su carrito de compra\")]");

    public static By montoIndividual;
    public static By botonFinalizar = By.xpath("//div/div/div/div/div/div//div/div/a[@href=\"//qalab.bensg.com/store/es/carrito?action=show\"]");;
}
