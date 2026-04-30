package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutInfoPage {
    public static final Target ADDRESS_FIELD = Target.the("campo direccion")
            .located(AppiumBy.xpath("//android.widget.EditText[1]"));

    public static final Target CITY_FIELD = Target.the("campo ciudad")
            .located(AppiumBy.xpath("//android.widget.EditText[2]"));

    public static final Target ZIP_CODE_FIELD = Target.the("campo codigo postal")
            .located(AppiumBy.xpath("//android.widget.EditText[3]"));

    public static final Target YAPE_PAYMENT_METHOD = Target.the("opcion de pago Yape")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Yape']"));


    public static final Target ERROR_MESSAGE = Target.the("mensaje de error direccion")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='La dirección es requerida']"));

    public static final Target YAPE_OPTION = Target.the("opcion de pago Yape")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Yape']/preceding-sibling::android.widget.RadioButton | //android.widget.RadioButton[following-sibling::android.widget.TextView[@text='Yape']] | //android.widget.TextView[@text='Yape']"));
}