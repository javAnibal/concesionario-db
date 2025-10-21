package model;

import java.util.Objects;


/**
 * @Equipamiento -> objeto cuyo principal objetivo es ser parte de la colección de equipamientos de un coche,
 * controlando que no se repitan mediante el uso de [equals - hastCode]
 */
public class Equipamiento {

    private String extra;


    public Equipamiento(String extra) {
        this.extra = extra;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Equipamiento that)) return false;
        return Objects.equals(getExtra(), that.getExtra());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getExtra());
    }

    @Override
    public String toString() {
        return "Equipamiento{" +
                "extra='" + extra + '\'' +
                '}';
    }
}
