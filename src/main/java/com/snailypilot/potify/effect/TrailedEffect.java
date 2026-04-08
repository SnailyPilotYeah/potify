package com.snailypilot.potify.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class TrailedEffect extends MobEffect {
    public TrailedEffect() {
        super(MobEffectCategory.NEUTRAL, 0x2CA164);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        if (entity instanceof Player) {
            double x = entity.getX();
            double y = entity.getY() + entity.getEyeHeight() / 2;
            double z = entity.getZ();

            int particleCount = 4 + amplifier * 2;
            for (int i = 0; i < particleCount; i++) {
                double angle = (i / (double) particleCount) * Math.PI * 2;
                double offsetX = Math.cos(angle) * 0.5;
                double offsetZ = Math.sin(angle) * 0.5;

                level.sendParticles(ParticleTypes.HAPPY_VILLAGER,
                        x + offsetX, y, z + offsetZ,
                        1, 0, 0, 0, 0);
            }
        }

        return super.applyEffectTick(level, entity, amplifier);
    }
}