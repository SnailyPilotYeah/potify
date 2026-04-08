package com.snailypilot.potify.effect;

import com.snailypilot.potify.ModEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FrozenEffect extends MobEffect {
    public FrozenEffect() {
        super(MobEffectCategory.HARMFUL, 0xACE5EE);
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        // Freezing handled by FrozenEffect Mixin.java
        if (entity.hasEffect(ModEffects.SLIPPED)) {
            entity.removeEffect(ModEffects.SLIPPED);
        } else if (entity.hasEffect(ModEffects.GROUNDED)) {
            entity.removeEffect(ModEffects.GROUNDED);
        }
        return super.applyEffectTick(level, entity, amplifier);
    }
}
