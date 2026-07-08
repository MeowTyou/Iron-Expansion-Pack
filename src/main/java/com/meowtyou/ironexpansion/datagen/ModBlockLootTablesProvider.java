package com.meowtyou.ironexpansion.datagen;

import com.meowtyou.ironexpansion.block.Modblocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTablesProvider extends BlockLootSubProvider {
    public ModBlockLootTablesProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(Modblocks.STEEL_BLOCK.get());

        dropSelf(Modblocks.STEEL_STAIR.get());
        add(Modblocks.STEEL_SLAB.get(),
                block -> createSlabItemTable(Modblocks.STEEL_SLAB.get()));
        dropSelf(Modblocks.STEEL_BUTTON.get());
        dropSelf(Modblocks.STEEL_PRESSURE_PLATE.get());
        dropSelf(Modblocks.STEEL_FENCE_GATE.get());
        dropSelf(Modblocks.STEEL_FENCE.get());
        add(Modblocks.STEEL_DOOR.get(),
                block -> createDoorTable(Modblocks.STEEL_DOOR.get()));
        dropSelf(Modblocks.STEEL_TRAPDOOR.get());

        dropSelf(Modblocks.IRON_STAIR.get());
        add(Modblocks.IRON_SLAB.get(),
                block -> createSlabItemTable(Modblocks.IRON_SLAB.get()));
        dropSelf(Modblocks.IRON_BUTTON.get());
        dropSelf(Modblocks.IRON_FENCE_GATE.get());
        dropSelf(Modblocks.IRON_FENCE.get());
    }

    protected LootTable.Builder createCopperOreLikeDrops(Block pBlock,Item item){
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F,5.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Modblocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

