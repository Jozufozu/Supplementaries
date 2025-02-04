package net.mehvahdjukaar.supplementaries.client.renderers.color;

import net.mehvahdjukaar.supplementaries.common.configs.ClientConfigs;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;

public class CrossbowColor implements ItemColor {


    @Override
    public int getColor(ItemStack stack, int tint) {
        CompoundTag tag = stack.getTag();
        if (tint == 1 && ClientConfigs.cached.COLORED_ARROWS) {
            if (tag != null && tag.contains("ChargedProjectiles", 9)) {
                ListTag chargedProjectiles = tag.getList("ChargedProjectiles", 10);
                if (chargedProjectiles.size() > 0) {
                    CompoundTag compoundnbt1 = chargedProjectiles.getCompound(0);
                    ItemStack arrow = ItemStack.of(compoundnbt1);
                    Item i = arrow.getItem();
                    if (i == Items.TIPPED_ARROW) return PotionUtils.getColor(arrow);
                    else if (i == Items.SPECTRAL_ARROW) return 0xFFAA00;
                }
            }
        }
        return -1;
    }

}

