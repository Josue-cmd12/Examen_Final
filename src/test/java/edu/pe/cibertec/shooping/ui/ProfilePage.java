package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ProfilePage {
    public static final Target PROFILE_TAB = Target.the("pestaña perfil")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Perfil']"));

    public static final Target USERNAME_LABEL = Target.the("nombre del usuario logueado")
            .located(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Juan')]"));

    public static final Target LOGOUT_ICON = Target.the("icono cerrar sesión")
            .located(AppiumBy.xpath("//android.widget.Button[@content-desc='Cerrar sesión']"));

    public static final Target CONFIRM_LOGOUT_BUTTON = Target.the("botón confirmar cierre")
            .located(AppiumBy.xpath("//android.widget.TextView[contains(@text,'cerrar')]"));
}