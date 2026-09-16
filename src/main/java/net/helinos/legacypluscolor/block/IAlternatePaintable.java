package net.helinos.legacypluscolor.block;

import org.jetbrains.annotations.NotNull;

import net.helinos.legacypluscolor.AlternateDyeColor;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;

public interface IAlternatePaintable {
    default boolean canBePainted() {
        return true;
    }

    void setColor(@NotNull World var1, @NotNull TilePosc var2, @NotNull AlternateDyeColor var3);
}
