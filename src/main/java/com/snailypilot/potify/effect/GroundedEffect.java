package com.snailypilot.potify.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class GroundedEffect extends MobEffect {
    public GroundedEffect() {
        super(MobEffectCategory.HARMFUL, 0x778899);
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        // Jump reduction is handled by the mixin
        return super.applyEffectTick(level, entity, amplifier);
    }
}
