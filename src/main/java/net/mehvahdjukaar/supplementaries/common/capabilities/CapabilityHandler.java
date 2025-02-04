package net.mehvahdjukaar.supplementaries.common.capabilities;

import net.mehvahdjukaar.supplementaries.Supplementaries;
import net.mehvahdjukaar.supplementaries.api.IAntiqueTextProvider;
import net.mehvahdjukaar.supplementaries.api.ICatchableMob;
import net.mehvahdjukaar.supplementaries.common.capabilities.antique_ink.AntiqueInkProvider;
import net.mehvahdjukaar.supplementaries.common.configs.RegistryConfigs;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;

import javax.annotation.Nonnull;

public class CapabilityHandler {

    public static final Capability<ICatchableMob> CATCHABLE_MOB_CAP = CapabilityManager.get(new CapabilityToken<>() {
    });
    public static final Capability<IAntiqueTextProvider> ANTIQUE_TEXT_CAP = CapabilityManager.get(new CapabilityToken<>() {
    });

    public static void register(RegisterCapabilitiesEvent event) {
        event.register(ICatchableMob.class);
        event.register(IAntiqueTextProvider.class);
    }

    public static final boolean ANTIQUE_CAP_ENABLED = RegistryConfigs.reg.ANTIQUE_INK_ENABLED.get();

    public static void attachCapabilities(AttachCapabilitiesEvent<BlockEntity> event) {
        if (ANTIQUE_CAP_ENABLED && event.getObject() instanceof SignBlockEntity) {
            event.addCapability(Supplementaries.res( "antique_ink"), new AntiqueInkProvider());
        }
    }


}
