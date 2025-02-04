package net.mehvahdjukaar.supplementaries.datagen.types;

import net.mehvahdjukaar.supplementaries.setup.ModRegistry;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.ModList;

public interface IWoodType {

    String toString();

    default String getRegName(){return this.toString();}

    default String toNBT(){return this.getNamespace()+":"+this.toString();}

    /*
    default ResourceLocation toResourceLocation(){
        return new ResourceLocation(this.getNamespace(),this.toString());
    }*/

    default Material getMaterial(){
        return Blocks.OAK_PLANKS.defaultBlockState().getMaterial();
    }

    default MaterialColor getColor(){
        return Blocks.OAK_PLANKS.defaultMaterialColor();
    }

    String getNamespace();

    default String getLocation(String name){
        return this.getNamespace()+"/"+name;
    }

    default String getPlankRegName() {
        return this.getNamespace()+":"+ this +"_planks";
    }

    default String getSignRegName(){
        return this.getNamespace()+":"+ this +"_sign";
    }

    default String getHangingSignName(){
        return ModRegistry.HANGING_SIGN_NAME + "_" + this.getRegName();
    }

    default String getSignPostName(){
        return ModRegistry.SIGN_POST_NAME + "_" + this.getRegName();
    }

    default String getTranslationName(){
        return this.toString();

    }

    default boolean isModActive(){
        return ModList.get().isLoaded(this.getNamespace());
    }

}