package net.mehvahdjukaar.supplementaries.integration;


import net.mehvahdjukaar.supplementaries.integration.cctweaked.CCStuff;
import net.mehvahdjukaar.supplementaries.integration.create.SupplementariesCreatePlugin;
import net.mehvahdjukaar.supplementaries.integration.decorativeblocks.DecoBlocksCompatRegistry;
import net.mehvahdjukaar.supplementaries.integration.farmersdelight.FDCompatRegistry;
import net.mehvahdjukaar.supplementaries.integration.quark.QuarkPlugin;
import net.minecraftforge.fml.ModList;
import vazkii.quark.base.handler.GeneralConfig;
import vazkii.quark.content.building.module.VerticalSlabsModule;

public class CompatHandler {

    public static final boolean quark;
    public static final boolean deco_blocks;
    public static final boolean configured;
    public static final boolean create;
    public static final boolean torchslab;
    public static final boolean curios;
    public static final boolean farmers_delight;
    public static final boolean infernalexp;
    public static final boolean inspirations;
    public static final boolean framedblocks;
    public static final boolean rgblib;
    public static final boolean endergetic;
    public static final boolean buzzier_bees;
    public static final boolean autumnity;
    public static final boolean deco_blocks_abnormals;
    public static final boolean much_more_mod_compat;
    public static final boolean flywheel;
    public static final boolean repurposed_structures;
    public static final boolean tetra;
    public static final boolean pokecube_legends;
    public static final boolean pokecube;
    public static final boolean dynamictrees;
    public static final boolean moreminecarts;
    public static final boolean habitat;
    public static final boolean simplefarming;
    public static final boolean atmospheric;
    public static final boolean enchantedbookredesign;
    public static final boolean computercraft;
    public static final boolean customvillagertrades;
    public static final boolean nethersdelight;
    public static final boolean doubledoors;
    public static final boolean malum;

    static {
        ModList ml = ModList.get();
        quark = ml.isLoaded("quark");
        deco_blocks = ml.isLoaded("decorative_blocks");
        configured = ml.isLoaded("configured");
        create = ml.isLoaded("create");
        torchslab = ml.isLoaded("torchslabmod");
        curios = ml.isLoaded("curios");
        farmers_delight = ml.isLoaded("farmersdelight");
        infernalexp = ml.isLoaded("infernalexp");
        inspirations = ml.isLoaded("inspirations");
        framedblocks = ml.isLoaded("framedblocks");
        rgblib = ml.isLoaded("rgblib");
        endergetic = ml.isLoaded("endergetic");
        deco_blocks_abnormals = ml.isLoaded("decorative_blocks_abnormals");
        much_more_mod_compat = ml.isLoaded("muchmoremodcompat");
        autumnity = ml.isLoaded("autumnity");
        buzzier_bees = ml.isLoaded("buzzier_bees");
        flywheel = ml.isLoaded("flywheel");
        repurposed_structures = ml.isLoaded("repurposed_structures");
        tetra = ml.isLoaded("tetra");
        pokecube_legends = ml.isLoaded("pokecube_legends");
        pokecube = ml.isLoaded("pokecube");
        dynamictrees = ml.isLoaded("dynamictrees");
        moreminecarts = ml.isLoaded("moreminecarts");
        habitat = ml.isLoaded("habitat");
        simplefarming = ml.isLoaded("simplefarming");
        atmospheric = ml.isLoaded("atmospheric");
        enchantedbookredesign = ml.isLoaded("enchantedbookredesign");
        customvillagertrades = ml.isLoaded("customvillagertrades");
        computercraft = ml.isLoaded("computercraft");
        nethersdelight = ml.isLoaded("nethers_delight");
        doubledoors = ml.isLoaded("doubledoors");
        malum = ml.isLoaded("malum");
    }

    public static void init() {
        if (create) SupplementariesCreatePlugin.initialize();
        if (computercraft) CCStuff.initialize();
    }

    public static void registerOptionalStuff() {
        if (deco_blocks) DecoBlocksCompatRegistry.registerStuff();
        if (farmers_delight) FDCompatRegistry.registerStuff();
        //if (inspirations) CauldronRecipes.registerStuff();
        //if (botania) BotaniaCompatRegistry.registerStuff();
    }


}
