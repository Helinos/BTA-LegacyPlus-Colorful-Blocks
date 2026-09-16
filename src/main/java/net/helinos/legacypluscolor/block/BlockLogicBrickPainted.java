package net.helinos.legacypluscolor.block;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.helinos.legacypluscolor.AlternateDyeColor;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;

public class BlockLogicBrickPainted extends BlockLogic implements IAlternatePainted, BlockLogic.MatcherDataEquivalency {
    public BlockLogicBrickPainted(@NotNull Block<?> block) {
        super(block, Materials.STONE);
    }

    @Override
    public @NotNull String getLanguageKey(int meta) {
        return super.getLanguageKey(meta) + "." + this.fromMetadata(meta).colorID;
    }

    @Override
    public int getPlacedData(@Nullable Player player, @NotNull ItemStack itemStack, @NotNull World world,
            @NotNull TilePosc tilePos, @NotNull Side side, double xHit, double yHit) {
        return itemStack.getMetadata() % AlternateDyeColor.COLOR_AMOUNT;
    }

    @Override
    public ItemStack[] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data,
            @Nullable TileEntity tileEntity) {
        return new ItemStack[] { new ItemStack(this, 1, data) };
    }

    public @NotNull AlternateDyeColor fromMetadata(int meta) {
        return AlternateDyeColor.colorFromMeta(meta % AlternateDyeColor.COLOR_AMOUNT);
    }

    public int toMetadata(@NotNull AlternateDyeColor color) {
        return color.meta;
    }

    public int stripColorFromMetadata(int meta) {
        return 0;
    }

    public void removeDye(@NotNull World world, @NotNull TilePosc tilePos) {
        world.setBlockTypeDataNotify(tilePos, Blocks.BRICK_CLAY, 0);
    }
}
