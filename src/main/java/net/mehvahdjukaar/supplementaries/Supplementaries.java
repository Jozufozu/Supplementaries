package net.mehvahdjukaar.supplementaries;

import me.thonk.croptopia.blocks.CroptopiaCropBlock;
import me.thonk.croptopia.items.CroptopiaSaplingItem;
import net.mehvahdjukaar.selene.fluids.SoftFluidRegistry;
import net.mehvahdjukaar.supplementaries.common.configs.ConfigHandler;
import net.mehvahdjukaar.supplementaries.common.events.ServerEvents;
import net.mehvahdjukaar.supplementaries.common.world.generation.WorldGenHandler;
import net.mehvahdjukaar.supplementaries.common.items.crafting.RecipeCondition;
import net.mehvahdjukaar.supplementaries.integration.farmersdelight.PlanterRichBlock;
import net.mehvahdjukaar.supplementaries.setup.ClientSetup;
import net.mehvahdjukaar.supplementaries.setup.ModRegistry;
import net.mehvahdjukaar.supplementaries.setup.ModSetup;
import net.mehvahdjukaar.supplementaries.setup.ModSoftFluids;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Supplementaries.MOD_ID)
public class Supplementaries {

    public static final String MOD_ID = "supplementaries";

    public static final Logger LOGGER = LogManager.getLogger();

    public static ResourceLocation res(String n) {
        return new ResourceLocation(MOD_ID, n);
    }

    public static String str(String n) {
        return MOD_ID + ":" + n;
    }

    public Supplementaries() {

        //animated lantern textures
        //add option for soul jar
        //ash jei plugin
        //bundle sound for sacks
        //bellows bubble
        //FIx spikes piston movements
        //TODO: fish bucket on cages a
        //TODO: shift click to pickup placed book

        //TODO: fix slingshot proj not playing sound on client (all messed up)
        //yes this is where I write crap. deal with it XD

        //todo: fix projectile hitbox being a single point on y = 0

        //add chain knot

        //elytra acrobatics mod

        //swaying blocks water friction

        //horizontal shearable ropes

        //TODO: more flywheel stuff

        //TODO: improve feather particle


        //use feather particle on spriggans

        //TODO: fix JER loot tables percentages

        //zipline mod ropewalk

        //GLOBE inv model
        //TODO: goblet & jars dynamic baked model
        //ghast fireball mob griefing

        //Bamboo spikes damage fall

        //TODO: fireflies deflect arrows

        //firefly glow block

        //TODO: replace soft fluid system with forge caps to itemstacks and register actual forge fluids

        //TODO: bugs: bell ropes(add to flywheel instance), brewing stand colors(?)

        //TODO: mod ideas: particle block, blackboard banners and flags, lantern holding

        //TODO: add stick window loggable clipping

        //flute animation fix

        //add shift middle click to swap to correct tool

        //mod idea: blackboard banners and flags with villager
        //weed mod

        //throwable slimeballs

        //TODO: make dummy not show numbers at a distance, headshot

        //simple mode for doors and trapdoors

        //data driven fluid system

        //label

        //animated pulley texture

        //TODO: add support for new game events

        //TODO: faucets create sprout

        // randomium item particle when drop

        //TODO: xp bottling whose cost depends on player total xp
        //TODO: randomium that can spawn in other dimensions via whitelist

        //todo: serene easons & moon stuff for haunted harvest

        //TODO: wiki for custom map markers icons. add simple icon datapacks

        //randomium can give onl stuff already obtained by a player in survival

        //golden carrots to breed baby pignis

        //directional books fixed
        //particles for randomium
        //data driven fluid system :0
        //TODO: credist screen

        //TODO: way signs as villages pieces
        //slime balls

        //small honey slime in cage


        //skii mod
        //blackboard texture glitchyness (baked model)

        //fix cauldron & faucet & update visual water

        //ender pearls dispensers

        //idea: Increase range of enchantment table

        //TODO: fix faucet water is completely bugged
        //IRON gate connected model

        //hud mod. armor broken hud, items offhadn crafting

        //structures

        //ash auto bonemeal, improve bubbles

        //redo achievement rendering
        //better badlands kindling gunpowder compat (whenevr it updates lol)
        //better fodder pathfinding
        //TODO fix randomium recipe jei extensin

        //TODO: add dispenser like interaction registry for faucet
        //TODO: flax upper stage grows depending on lower

        ConfigHandler.init();

        CraftingHelper.register(new RecipeCondition.Serializer("flag"));

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModRegistry.init(bus);

        WorldGenHandler.init();

        bus.addListener(ModSetup::init);

        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> bus.addListener(ClientSetup::init));

        MinecraftForge.EVENT_BUS.register(ServerEvents.class);

    }


}
