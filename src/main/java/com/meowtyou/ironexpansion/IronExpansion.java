package com.meowtyou.ironexpansion;

import com.meowtyou.ironexpansion.block.Modblocks;
import com.meowtyou.ironexpansion.item.Moditems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IronExpansion.MOD_ID)
public class IronExpansion
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "ironexpansion";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public IronExpansion(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        Moditems.register(modEventBus);
        Modblocks.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey()== CreativeModeTabs.INGREDIENTS){
            event.accept(Moditems.Steel_Nugget.get());
            event.accept(Moditems.Steel_Ingot);
        }

        if(event.getTabKey()== CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(Modblocks.STEEL_BLOCK);
            event.accept(Modblocks.STEEL_STAIR);
            event.accept(Modblocks.STEEL_SLAB);
            event.accept(Modblocks.STEEL_BUTTON);
            event.accept(Modblocks.STEEL_PRESSURE_PLATE);
            event.accept(Modblocks.STEEL_FENCE_GATE);
            event.accept(Modblocks.STEEL_FENCE);
            event.accept(Modblocks.STEEL_DOOR);
            event.accept(Modblocks.STEEL_TRAPDOOR);

            event.accept(Modblocks.IRON_STAIR);
            event.accept(Modblocks.IRON_SLAB);
            event.accept(Modblocks.IRON_FENCE_GATE);
            event.accept(Modblocks.IRON_FENCE);
            event.accept(Modblocks.IRON_BUTTON);
        }

        if (event.getTabKey()== CreativeModeTabs.COMBAT){
            event.accept(Moditems.STEEL_SWORD);
            event.accept(Moditems.STEEL_AXE);
            event.accept(Moditems.STEEL_HELMET);
            event.accept(Moditems.STEEL_CHESTPLATE);
            event.accept(Moditems.STEEL_LEGGINGS);
            event.accept(Moditems.STEEL_BOOTS);
        }

        if (event.getTabKey()== CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(Moditems.STEEL_AXE);
            event.accept(Moditems.STEEL_HOE);
            event.accept(Moditems.STEEL_PICKAXE);
            event.accept(Moditems.STEEL_SHOVEL);
        }

        if(event.getTabKey()== CreativeModeTabs.REDSTONE_BLOCKS){

        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
