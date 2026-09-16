package net.helinos.legacypluscolor.block;

import org.jetbrains.annotations.NotNull;

import net.helinos.legacypluscolor.AlternateDyeColor;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;

public interface IAlternatePainted extends IAlternatePaintable {
    @NotNull
    AlternateDyeColor fromMetadata(int meta);

    int toMetadata(@NotNull AlternateDyeColor dyeColor);

    int stripColorFromMetadata(int meta);

    void removeDye(@NotNull World world, @NotNull TilePosc tilePos);

    default @NotNull AlternateDyeColor getColor(@NotNull World world, @NotNull TilePosc tilePos) {
        return this.fromMetadata(world.getBlockData(tilePos));
    }

    @Override
    default void setColor(@NotNull World world, @NotNull TilePosc tilePos, @NotNull AlternateDyeColor color) {
        int data = world.getBlockData(tilePos);
        world.setBlockDataNotify(tilePos, this.stripColorFromMetadata(data) | this.toMetadata(color));
    }
}
