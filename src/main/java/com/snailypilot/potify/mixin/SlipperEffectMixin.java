package com.snailypilot.potify.mixin;

import com.snailypilot.potify.ModEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class SlipperEffectMixin {
    @Inject(method = "travel", at = @At("HEAD"))
    private void onTravel(CallbackInfo info) {
        LivingEntity entity = (LivingEntity) (Object) this;

        if (entity.hasEffect(ModEffects.SLIPPED) && entity.onGround()) {
            entity.setOnGround(false);
        }
    }
}
