package net.helinos.legacypluscolor.block;

import net.helinos.legacypluscolor.LegacyPlusColor;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.tag.BlockTags;
import turniplabs.halplibe.helper.BlockBuilder;

public class LegacyPlusColorBlocks {

    public static Block<BlockLogicBrickPainted> BRICK_CLAY_PAINTED;

    private static boolean alreadyInitialized = false;
    private static final int STARTING_BLOCK_ID = 3200;
    private static int blockIdCounter = STARTING_BLOCK_ID;

    public static void init() {
        if (alreadyInitialized)
            return;

        alreadyInitialized = true;
        initializeBlocks();
    }

    public static void initializeBlocks() {
        LegacyPlusColor.LOGGER.info("Initializing Blocks.");

        BRICK_CLAY_PAINTED = new BlockBuilder(LegacyPlusColor.MOD_ID)
                .setBlockSound(Blocks.BRICK_CLAY.getSound())
                .setHardness(Blocks.BRICK_CLAY.getHardness())
                .setResistance(Blocks.BRICK_CLAY.blastResistance)
                .addTags(BlockTags.MINEABLE_BY_PICKAXE, BlockTags.CHAINLINK_FENCES_CONNECT)
                .build("brick", blockIdCounter++, BlockLogicBrickPainted::new);
    }
}
