package net.helinos.legacypluscolor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.helinos.legacypluscolor.block.BlockLogicBrickPainted;
import net.helinos.legacypluscolor.block.LegacyPlusColorBlocks;
import net.helinos.legacypluscolor.model.BlockModelGenericBrickPainted;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.texture.stitcher.AtlasStitcher;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.util.helper.DyeColor;
import turniplabs.halplibe.event.defs.ClientEvents;
import turniplabs.halplibe.helper.TextureHelper;
import turniplabs.halplibe.util.dependency.Key;

import static net.helinos.legacypluscolor.LegacyPlusColor.MOD_ID;

@Environment(EnvType.CLIENT)
public class LegacyPlusColorClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientEvents.AFTER_CLIENT_START.listen(Key.of(MOD_ID), LegacyPlusColorClient::afterClientStart);
        ClientEvents.BEFORE_CLIENT_START.listen(Key.of(MOD_ID),
                LegacyPlusColorClient::beforeClientStart);
        ClientEvents.BLOCK_MODEL_RELOAD.listen(Key.of(MOD_ID), LegacyPlusColorClient::initBlockModels);
    }

    public static void beforeClientStart() {
        LegacyPlusColorClient.registerTextures();
    }

    public static void afterClientStart() {

    }

    public static void registerTextures() {
        for (final AtlasStitcher stitcher : TextureRegistry.stitcherMap.values()) {
            TextureHelper.initializeAllFiles(MOD_ID, stitcher, true);
        }
    }

    public static void initBlockModels(BlockModelDispatcher dispatcher) {
        String rootKey = MOD_ID + ":block/brick/";

        dispatcher.addDispatch(
                new BlockModelGenericBrickPainted<BlockLogicBrickPainted>(LegacyPlusColorBlocks.BRICK_CLAY_PAINTED,
                        BlockModelDispatcher.loadDataModel(rootKey + DyeColor.WHITE.colorID), rootKey));
    }
}
