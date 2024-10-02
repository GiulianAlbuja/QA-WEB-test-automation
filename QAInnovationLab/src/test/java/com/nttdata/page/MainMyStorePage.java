package com.nttdata.page;

import org.openqa.selenium.By;

public class MainMyStorePage {
    public static By categoriaBoton = By.xpath("//a[@href='https://qalab.bensg.com/store/es/3-clothes']");
    public static By subcategoriaBoton = By.xpath("//li/ul/li/a[@href='https://qalab.bensg.com/store/es/4-men']");
    public static By sesion = By.xpath("//a[@href='https://qalab.bensg.com/store/es/?mylogout=' and @class='logout hidden-sm-down']");
}
