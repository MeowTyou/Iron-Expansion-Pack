package com.meowtyou.ironexpansion.item;

import com.meowtyou.ironexpansion.IronExpansion;
import com.meowtyou.ironexpansion.tag.ModBlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;
import java.util.function.Supplier;

public enum ModToolTiers implements Tier {
    STEEL(3,800,7.0F,2.5F,14, () -> Ingredient.of(Moditems.Steel_Ingot.get()));

    public static final Tier STEEL_INGOT = TierSortingRegistry.registerTier(
            new ForgeTier(3,800,7.0F,2.5F,14,
                    ModBlockTags.ORE_TAGS,() -> Ingredient.of(Moditems.Steel_Ingot.get())),
            ResourceLocation.fromNamespaceAndPath(IronExpansion.MOD_ID,"steel_ingot"), List.of(Tiers.IRON),List.of());

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredients;

    ModToolTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredients) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredients = repairIngredients;
    }

    public int getUses(){return this.uses;}

    public float getSpeed(){return this.speed;}

    public float getAttackDamageBonus(){return this.damage;}

    public int getLevel(){return this.level;}

    public int getEnchantmentValue(){return this.enchantmentValue;}

    public Ingredient getRepairIngredient(){

        return this.repairIngredients.get();
    }
}
