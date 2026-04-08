package com.snailypilot.potify.mixin;

import com.snailypilot.potify.ModEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class GroundedEffectMixin {
    @Inject(method = "jumpFromGround", at = @At("HEAD"), cancellable = true)
    private void onJumpFromGround(CallbackInfo info) {
        LivingEntity entity = (LivingEntity) (Object) this;

        // Check if the entity has the Grounded effect
        if (entity.hasEffect(ModEffects.GROUNDED)) {
            // Cancel the normal jump
            info.cancel();

            // Apply a reduced jump
            entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, 0.42F * 0.6D, 0.0D));

            if (entity.isSprinting()) {
                float yaw = entity.getYRot() * 0.017453292F;
                entity.setDeltaMovement(entity.getDeltaMovement().add(-0.2F * 0.5D * Math.sin(yaw), 0.0D, 0.2F * 0.5D * Math.cos(yaw)));
            }
        }
    }
}

