package net.helinos.legacypluscolor.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import net.helinos.legacypluscolor.block.BlockLogicBrickPainted;
import net.minecraft.core.block.BlockLogicSupplier;
import net.minecraft.core.block.Blocks;

@Mixin(value = Blocks.class, remap = false, priority = 1000)
public abstract class BlocksMixin {
    // @ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target =
    // "Lnet/minecraft/core/block/Blocks;register(Ljava/lang/String;Ljava/lang/String;ILnet/minecraft/core/block/BlockLogicSupplier;)Lnet/minecraft/core/block/Block;"))
    // private static void interceptBlockRegistration(Args args) {
    // String key = args.get(0);
    // String namespaceId = args.get(1);
    // int id = args.get(2);

    // if (key == "brick.clay" && namespaceId == "minecraft:block/brick_clay" && id
    // == 120) {
    // System.out.println("match");
    // BlockLogicSupplier<BlockLogicColoredBrick> coloredBrickLogic =
    // BlockLogicColoredBrick::new;
    // args.set(3, coloredBrickLogic);
    // }
    // }
}
