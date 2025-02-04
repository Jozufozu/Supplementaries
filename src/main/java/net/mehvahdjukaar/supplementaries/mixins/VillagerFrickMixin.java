package net.mehvahdjukaar.supplementaries.mixins;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.behavior.VillagerMakeLove;
import net.minecraft.world.entity.npc.Villager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VillagerMakeLove.class)
public abstract class VillagerFrickMixin {

    private boolean isNear = false;

    @Inject(method = {"tick*"},
            at = {@At(value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/ai/behavior/BehaviorUtils;lockGazeAndWalkToEachOther(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/world/entity/LivingEntity;F)V"
            )})
    private void tick1(ServerLevel p_212833_1_, Villager villager, long p_212833_3_, CallbackInfo ci) {
        if(!isNear){
            isNear = true;
            villager.level.broadcastEntityEvent(villager, (byte)15);
            //NetworkHandler.sendToAllTracking(villager, (ServerWorld) villager.level,new NosePacket(villager.getId(),true));
        }
    }

    @Redirect(method = "tick*",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/entity/npc/Villager;distanceToSqr(Lnet/minecraft/world/entity/Entity;)D"
                    ))
    private double tick3(Villager villagerEntity, Entity entity) {
        double dist = villagerEntity.distanceToSqr(entity);
        if(dist > 5.0D && this.isNear){
            this.isNear = false;
            villagerEntity.level.broadcastEntityEvent(villagerEntity, (byte)16);
            //NetworkHandler.sendToAllTracking(villagerEntity, (ServerWorld) villagerEntity.level,new NosePacket(villagerEntity.getId(),false));
        }
        return dist;
    }


    @Inject(method = {"stop*"},
            at = {@At(value = "TAIL")})
    private void stop(ServerLevel serverLevel, Villager villager, long l, CallbackInfo ci) {
        villager.level.broadcastEntityEvent(villager, (byte)16);
        //NetworkHandler.sendToAllTracking(villager, (ServerWorld) villager.level,new NosePacket(villager.getId(),false));
        isNear = false;
    }



}
