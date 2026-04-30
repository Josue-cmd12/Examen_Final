package edu.pe.cibertec.shooping.ui;


import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CatalogPage {
    public static final Target CATALOG_TITLE = Target.the("titulo del catalogo")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Productos']"));

    public static final Target SEARCH_FIELD = Target.the("campo de busqueda")
            .located(AppiumBy.className("android.widget.EditText"));


    public static Target productByName(String productName){
        return Target.the("producto " + productName)
                .located(AppiumBy.xpath("//*[contains(@content-desc,'" + productName + "') or contains(@text,'" + productName + "')]"));
    }

    public static Target categoryFilter(String category) {
        return Target.the("filtro de categoria " + category)
                .located(AppiumBy.xpath("//android.widget.TextView[@text='" + category + "']"));
    }
}
