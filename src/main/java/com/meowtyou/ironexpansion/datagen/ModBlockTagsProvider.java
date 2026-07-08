package com.meowtyou.ironexpansion.datagen;

import com.meowtyou.ironexpansion.IronExpansion;
import com.meowtyou.ironexpansion.block.Modblocks;
import com.meowtyou.ironexpansion.tag.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IronExpansion.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Modblocks.STEEL_BLOCK.get())
                .add(Modblocks.STEEL_STAIR.get())
                .add(Modblocks.STEEL_SLAB.get())
                .add(Modblocks.STEEL_BUTTON.get())
                .add(Modblocks.STEEL_PRESSURE_PLATE.get())
                .add(Modblocks.STEEL_FENCE_GATE.get())
                .add(Modblocks.STEEL_FENCE.get())
                .add(Modblocks.STEEL_DOOR.get())
                .add(Modblocks.STEEL_TRAPDOOR.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Modblocks.STEEL_BLOCK.get())
                .add(Modblocks.STEEL_STAIR.get())
                .add(Modblocks.STEEL_SLAB.get())
                .add(Modblocks.STEEL_BUTTON.get())
                .add(Modblocks.STEEL_PRESSURE_PLATE.get())
                .add(Modblocks.STEEL_FENCE_GATE.get())
                .add(Modblocks.STEEL_FENCE.get())
                .add(Modblocks.STEEL_DOOR.get())
                .add(Modblocks.STEEL_TRAPDOOR.get());

        tag(BlockTags.FENCES)
                .add(Modblocks.STEEL_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(Modblocks.STEEL_FENCE_GATE.get());

        tag(ModBlockTags.ORE_TAGS)
                .addTag(BlockTags.COAL_ORES)
                .addTag(BlockTags.IRON_ORES)
                .addTag(BlockTags.GOLD_ORES)
                .addTag(BlockTags.DIAMOND_ORES)
                .addTag(BlockTags.EMERALD_ORES)
                .addTag(BlockTags.LAPIS_ORES)
                .addTag(BlockTags.REDSTONE_ORES);
    }

}
