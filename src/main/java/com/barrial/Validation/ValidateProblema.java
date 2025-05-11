package com.barrial.Validation;

import com.barrial.DTO.ProblemaDTO;

public class ValidateProblema {
    public static boolean isValidProblemaBarrial(ProblemaDTO problemaDTO) {
        return isNameValid(problemaDTO.getNombre()) &&
                isDescriptionValid(problemaDTO.getDescripcion()) &&
                isImageValid(problemaDTO.getImagen());
    }

    public static boolean isValidURL(ProblemaDTO problemaDTO) {
        return isImageValid(problemaDTO.getImagen());
    }

    //Validar Nombre no tiene espacios al inicio ni al final
    public static boolean isNameValid(String name) {
        return name != null && !name.trim().isEmpty();
    }

    //Validar que Descripción tiene menos de 10.000 caracteres
    public static boolean isDescriptionValid(String description) {
        return description.length() <= 10000;
    }

    //Validar que la URL sea válida
    public static boolean isImageValid(String URLImagen) {
        return URLImagen.matches("https?://.+");
    }
}
