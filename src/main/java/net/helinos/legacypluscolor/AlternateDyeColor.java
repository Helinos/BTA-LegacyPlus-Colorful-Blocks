package net.helinos.legacypluscolor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public enum AlternateDyeColor {
    WHITE(0, "white"),
    LIGHT_GRAY(1, "light_gray"),
    DARK_GRAY(2, "dark_gray"),
    ROSE(3, "rose"),
    MAGENTA(4, "magenta"),
    PURPLE(5, "purple"),
    VIOLET(6, "violet"),
    ULTRAMARINE(7, "ultramarine"),
    CAPRI(8, "capri"),
    CYAN(9, "cyan"),
    GREEN(10, "spring_green"),
    SPRING_GREEN(11, "green"),
    CHARTREUSE(12, "chartreuse"),
    YELLOW(13, "yellow"),
    ORANGE(14, "orange"),
    RED(15, "red"),
    BLACK(16, "black"),
    BROWN(17, "brown");

    public static final int COLOR_AMOUNT = 18;

    private static final AlternateDyeColor[] metaToColor = new AlternateDyeColor[COLOR_AMOUNT];
    private static final List<AlternateDyeColor> colorList;

    public final int meta;
    public final String colorID;

    AlternateDyeColor(int meta, String colorID) {
        this.meta = meta;
        this.colorID = colorID;
    }

    public static @NotNull AlternateDyeColor colorFromMeta(int meta) {
        return metaToColor[meta % COLOR_AMOUNT];
    }

    public static @Unmodifiable List<AlternateDyeColor> orderedColors() {
        return colorList;
    }

    static {
        for (AlternateDyeColor c : values()) {
            metaToColor[c.meta] = c;
        }

        colorList = Collections.unmodifiableList(Arrays.asList(metaToColor));
    }
}
