package com.snailypilot.potify.effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SlippedEffect extends MobEffect {
    public SlippedEffect() {
        super(MobEffectCategory.NEUTRAL, 0x89CFF0);
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        // Effect handled by SlipperEffectMixin.java
        return super.applyEffectTick(level, entity, amplifier);
    }
}
