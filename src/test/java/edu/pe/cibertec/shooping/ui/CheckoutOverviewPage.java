package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutOverviewPage {
    public static final Target CONFIRM_BUTTON = Target.the("boton confirmar compra")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Confirmar Compra']"));
}
