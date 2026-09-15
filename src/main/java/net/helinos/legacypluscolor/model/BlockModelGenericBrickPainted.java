package net.helinos.legacypluscolor.model;

import org.jetbrains.annotations.NotNull;
import org.useless.dragonfly.data.block.BlockModelData;
import org.useless.dragonfly.models.block.StaticBlockModel;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.generic.BlockModelGeneric;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.DyeColor;

@Environment(EnvType.CLIENT)
public class BlockModelGenericBrickPainted<T extends BlockLogic> extends BlockModelGeneric<T> {
    public final StaticBlockModel[] models = new StaticBlockModel[16];

    public BlockModelGenericBrickPainted(@NotNull Block<T> block, @NotNull StaticBlockModel staticModel,
            @NotNull String rootKey) {
        super(block, staticModel);

        for (DyeColor dyeColor : DyeColor.blockOrderedColors()) {
            this.models[dyeColor.blockMeta] = BlockModelDispatcher
                    .loadDataModel(rootKey + dyeColor.colorID).asModel();
        }
    }

    public BlockModelGenericBrickPainted(@NotNull Block<T> block, @NotNull BlockModelData blockModel,
            @NotNull String rootKey) {
        super(block, blockModel);

        for (DyeColor dyeColor : DyeColor.blockOrderedColors()) {
            this.models[dyeColor.blockMeta] = BlockModelDispatcher
                    .loadDataModel(rootKey + dyeColor.colorID).asModel();
        }
    }

    public @NotNull StaticBlockModel getModelFromData(int data) {
        return this.models[data & 15];
    }
}
