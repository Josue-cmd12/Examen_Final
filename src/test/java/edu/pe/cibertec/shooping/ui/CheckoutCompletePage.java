package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutCompletePage {
    public static final Target SUCCESS_MESSAGE = Target.the("mensaje de pedido confirmado")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='¡Pedido Confirmado!']"));
}
