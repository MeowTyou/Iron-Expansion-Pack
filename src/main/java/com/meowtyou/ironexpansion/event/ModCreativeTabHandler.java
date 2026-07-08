package com.meowtyou.ironexpansion.event;

import com.meowtyou.ironexpansion.IronExpansion;
import com.meowtyou.ironexpansion.block.Modblocks;
import com.meowtyou.ironexpansion.item.Moditems;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IronExpansion.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTabHandler {

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        // 目标：原材料标签页
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            
            // 钢锭放在铁锭后面
            event.getEntries().putAfter(
                Items.IRON_INGOT.getDefaultInstance(),
                Moditems.Steel_Ingot.get().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Items.IRON_NUGGET.getDefaultInstance(),
                Moditems.Steel_Nugget.get().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }

        // 目标：战斗标签页
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.getEntries().putAfter(
                Items.IRON_SWORD.getDefaultInstance(),      //铁剑
                Moditems.STEEL_SWORD.get().getDefaultInstance(), // 钢剑
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Items.IRON_AXE.getDefaultInstance(),      //铁斧
                Moditems.STEEL_AXE.get().getDefaultInstance(), // 钢斧
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Items.IRON_BOOTS.getDefaultInstance(),      //铁靴子
                Moditems.STEEL_HELMET.get().getDefaultInstance(), // 钢头盔
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Moditems.STEEL_HELMET.get().getDefaultInstance(),      //钢头盔
                Moditems.STEEL_CHESTPLATE.get().getDefaultInstance(), // 钢胸甲
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Moditems.STEEL_CHESTPLATE.get().getDefaultInstance(),      //钢胸甲
                Moditems.STEEL_LEGGINGS.get().getDefaultInstance(), // 钢护腿
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Moditems.STEEL_LEGGINGS.get().getDefaultInstance(),      //钢护腿
                Moditems.STEEL_BOOTS.get().getDefaultInstance(), // 钢靴子
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
        
        // 1. 钢锹 → 放在铁锄后面
            event.getEntries().putAfter(
                Items.IRON_HOE.getDefaultInstance(),                // 铁锄
                Moditems.STEEL_SHOVEL.get().getDefaultInstance(),   // 钢锹
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

        // 2. 钢镐 → 放在【刚插入的钢锹】后面
            event.getEntries().putAfter(
                Moditems.STEEL_SHOVEL.get().getDefaultInstance(),   // 钢锹
                Moditems.STEEL_PICKAXE.get().getDefaultInstance(),  // 钢镐
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

        // 3. 钢斧 → 放在【钢镐】后面
            event.getEntries().putAfter(
                Moditems.STEEL_PICKAXE.get().getDefaultInstance(),
                Moditems.STEEL_AXE.get().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

        // 4. 钢锄 → 放在【钢斧】后面
            event.getEntries().putAfter(
                Moditems.STEEL_AXE.get().getDefaultInstance(),
                Moditems.STEEL_HOE.get().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
        
        // 1. 铁楼梯 → 放在【铁块】后面
            event.getEntries().putAfter(
                Items.IRON_BLOCK.getDefaultInstance(),                 // 参照物：铁块
                Modblocks.IRON_STAIR.get().asItem().getDefaultInstance(),      // 你的铁楼梯物品
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

        // 2. 铁台阶 → 放在【铁楼梯】后面
            event.getEntries().putAfter(
                Modblocks.IRON_STAIR.get().asItem().getDefaultInstance(),
                Modblocks.IRON_SLAB.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

        // 3. 铁栅栏 → 放在【铁台阶】后面
            event.getEntries().putAfter(
                Modblocks.IRON_SLAB.get().asItem().getDefaultInstance(),
                Modblocks.IRON_FENCE.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

        // 4. 铁栅栏门 → 放在【铁栅栏】后面
            event.getEntries().putAfter(
                Modblocks.IRON_FENCE.get().asItem().getDefaultInstance(),
                Modblocks.IRON_FENCE_GATE.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

        // 5. 铁按钮 → 放在【铁压力板】后面
            event.getEntries().putAfter(
                Items.HEAVY_WEIGHTED_PRESSURE_PLATE.getDefaultInstance(),
                Modblocks.IRON_BUTTON.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

        // 6. 钢系列放置在铁系列后
            event.getEntries().putAfter(
                Modblocks.IRON_BUTTON.get().asItem().getDefaultInstance(),
                Modblocks.STEEL_BLOCK.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Modblocks.STEEL_BLOCK.get().asItem().getDefaultInstance(),
                Modblocks.STEEL_STAIR.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Modblocks.STEEL_STAIR.get().asItem().getDefaultInstance(),
                Modblocks.STEEL_SLAB.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Modblocks.STEEL_SLAB.get().asItem().getDefaultInstance(),
                Modblocks.STEEL_FENCE.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Modblocks.STEEL_FENCE.get().asItem().getDefaultInstance(),
                Modblocks.STEEL_FENCE_GATE.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Modblocks.STEEL_FENCE_GATE.get().asItem().getDefaultInstance(),
                Modblocks.STEEL_DOOR.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Modblocks.STEEL_DOOR.get().asItem().getDefaultInstance(),
                Modblocks.STEEL_TRAPDOOR.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Modblocks.STEEL_TRAPDOOR.get().asItem().getDefaultInstance(),
                Modblocks.STEEL_PRESSURE_PLATE.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );

            event.getEntries().putAfter(
                Modblocks.STEEL_PRESSURE_PLATE.get().asItem().getDefaultInstance(),
                Modblocks.STEEL_BUTTON.get().asItem().getDefaultInstance(),
                CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS
            );
        }
    }
}
