package com.nttdata.stepsdefinitions;

import com.nttdata.steps.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;

public class MyStoreStepDef {
    private WebDriver driver;

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/es/iniciar-sesion");
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        LoginMyStoreStep login = new LoginMyStoreStep(driver);
        login.escribirUsuario(usuario);
        login.escribirClave(clave);
        login.clickSubmit();
        login.validarlogueo();

    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria){
        MainMyStoreStep mainMyStoreStep = new MainMyStoreStep(driver);
        mainMyStoreStep.clickCategoria(categoria);
        mainMyStoreStep.clickSubCategoria(subcategoria);

    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int unidades){
        MenMyStoreStep menMyStoreStep = new MenMyStoreStep(driver);
        ProductoMyStoreStep productoMyStoreStep = new ProductoMyStoreStep(driver);
        menMyStoreStep.seleccionarProducto();
        for(int i=0; i<unidades-1; i++){
            productoMyStoreStep.aumentarCantidadProductoEnUno();
        }
        productoMyStoreStep.agregoAlCarrito();

    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado(){
        ProductoMyStoreStep productoMyStoreStep = new ProductoMyStoreStep(driver);
        productoMyStoreStep.validarProductoAgregado();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        ProductoMyStoreStep productoMyStoreStep = new ProductoMyStoreStep(driver);
        productoMyStoreStep.validarMontoTotalCalculado();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra(){
        ProductoMyStoreStep productoMyStoreStep = new ProductoMyStoreStep(driver);
        productoMyStoreStep.finalizoCompra();

    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito(){
        CarritoMyStoreStep carritoMyStoreStep = new CarritoMyStoreStep(driver);
        carritoMyStoreStep.validarTitulo();

    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito(){
    }

}
