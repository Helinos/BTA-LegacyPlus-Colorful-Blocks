package net.helinos.legacypluscolor.model;

import org.jetbrains.annotations.NotNull;
import org.useless.dragonfly.data.block.BlockModelData;
import org.useless.dragonfly.models.block.StaticBlockModel;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.helinos.legacypluscolor.AlternateDyeColor;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.block.model.generic.BlockModelGeneric;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;

@Environment(EnvType.CLIENT)
public class BlockModelGenericBrickPainted<T extends BlockLogic> extends BlockModelGeneric<T> {
    public final StaticBlockModel[] models = new StaticBlockModel[AlternateDyeColor.COLOR_AMOUNT];

    public BlockModelGenericBrickPainted(@NotNull Block<T> block, @NotNull StaticBlockModel staticModel,
            @NotNull String rootKey) {
        super(block, staticModel);

        for (AlternateDyeColor dyeColor : AlternateDyeColor.orderedColors()) {
            this.models[dyeColor.meta] = BlockModelDispatcher
                    .loadDataModel(rootKey + dyeColor.colorID).asModel();
        }
    }

    public BlockModelGenericBrickPainted(@NotNull Block<T> block, @NotNull BlockModelData blockModel,
            @NotNull String rootKey) {
        super(block, blockModel);

        for (AlternateDyeColor dyeColor : AlternateDyeColor.orderedColors()) {
            this.models[dyeColor.meta] = BlockModelDispatcher
                    .loadDataModel(rootKey + dyeColor.colorID).asModel();
        }
    }

    public @NotNull StaticBlockModel getModelFromData(int data) {
        return this.models[data % AlternateDyeColor.COLOR_AMOUNT];
    }
}
