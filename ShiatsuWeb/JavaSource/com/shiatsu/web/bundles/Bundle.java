package com.shiatsu.web.bundles;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author oscar.monge
 *
 */
public class Bundle {
    /** Atributo <code>BUNDLES_RESOURCES</code> define el la dirección del paquete y del archivo en que se encuentran las etiquetas del programa.*/
    private static final String BUNDLES_RESOURCES = "com.shiatsu.web.bundles.recursos";
    
    public static final PropertyResourceBundle rcs = (PropertyResourceBundle) ResourceBundle.getBundle(Bundle.BUNDLES_RESOURCES);
}
