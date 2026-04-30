package edu.pe.cibertec.shooping.ui;


import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ProductsScreen {
    public static Target categoryFilter(String category) {
        return Target
                .the(category + " category filter")
                .located(AppiumBy.xpath("//android.widget.TextView[@text='" + category + "']"));
    }

    public static Target productByName(String productName) {
        return Target.the("Product: " + productName)
                .located(AppiumBy.xpath("//android.widget.TextView[contains(@text,'" + productName + "')]"));
    }
}
