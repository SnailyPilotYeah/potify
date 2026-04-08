package com.snailypilot.potify;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;

public class ModPotions implements ModInitializer {
    public static final Holder<Potion> TRAILED_POTION =
            Registry.registerForHolder(
                    BuiltInRegistries.POTION,
                    Identifier.fromNamespaceAndPath(Potify.MOD_ID, "trailed"),
                    new Potion("trailed",
                            new MobEffectInstance(
                                    ModEffects.TRAILED,
                                    3600
                            ))
            );

    public static final Holder<Potion> GROUNDED_POTION =
            Registry.registerForHolder(
                    BuiltInRegistries.POTION,
                    Identifier.fromNamespaceAndPath(Potify.MOD_ID, "grounded"),
                    new Potion("grounded",
                            new MobEffectInstance(ModEffects.GROUNDED,
                                    3600))
            );

    public static final Holder<Potion> SLIPPING_POTION =
            Registry.registerForHolder(
                    BuiltInRegistries.POTION,
                    Identifier.fromNamespaceAndPath(Potify.MOD_ID, "slipped"),
                    new Potion("slipped",
                            new MobEffectInstance(ModEffects.SLIPPED,
                                    3600))
            );

    public static final Holder<Potion> FREEZING_POTION =
            Registry.registerForHolder(
                    BuiltInRegistries.POTION,
                    Identifier.fromNamespaceAndPath(Potify.MOD_ID, "frozen"),
                    new Potion("frozen",
                            new MobEffectInstance(ModEffects.FROZEN,
                                    3600))
            );

    @Override
    public void onInitialize() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.addMix(
                    Potions.WATER,
                    Items.EMERALD,
                    TRAILED_POTION
            );
            builder.addMix(
                    Potions.SLOW_FALLING,
                    Items.WIND_CHARGE,
                    GROUNDED_POTION
            );
            builder.addMix(
                    Potions.WATER,
                    Item.byBlock(Blocks.POWDER_SNOW),
                    SLIPPING_POTION
            );
            builder.addMix(
                    Potions.WATER,
                    Item.byBlock(Blocks.BLUE_ICE),
                    FREEZING_POTION
            );
        });
    }
}
