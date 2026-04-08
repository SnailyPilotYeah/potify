package com.snailypilot.potify;

import com.snailypilot.potify.effect.GroundedEffect;
import com.snailypilot.potify.effect.SlippedEffect;
import com.snailypilot.potify.effect.TrailedEffect;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;

public class ModEffects implements ModInitializer {
    public static final Holder<MobEffect> TRAILED =
            Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(Potify.MOD_ID, "trailed"), new TrailedEffect());

    public static final Holder<MobEffect> GROUNDED =
            Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(Potify.MOD_ID, "grounded"), new GroundedEffect());

    public static final Holder<MobEffect> SLIPPED =
            Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(Potify.MOD_ID, "slipped"), new SlippedEffect());

    @Override
    public void onInitialize() {
    }
}

