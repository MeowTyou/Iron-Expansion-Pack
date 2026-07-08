package com.meowtyou.ironexpansion.item;

import com.meowtyou.ironexpansion.IronExpansion;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    STEEL_INGOT("steel_ingot",25,Util.make(new EnumMap(ArmorItem.Type.class),map ->{
        map.put(ArmorItem.Type.BOOTS,2);
        map.put(ArmorItem.Type.LEGGINGS,5);
        map.put(ArmorItem.Type.CHESTPLATE,7);
        map.put(ArmorItem.Type.HELMET,2);
    }),30, SoundEvents.ARMOR_EQUIP_IRON,1.0F,0,() -> Ingredient.of(Moditems.Steel_Ingot.get()));

    private static final EnumMap<ArmorItem.Type,Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class),(map) -> {
        map.put(ArmorItem.Type.BOOTS,13);
        map.put(ArmorItem.Type.LEGGINGS,15);
        map.put(ArmorItem.Type.CHESTPLATE,16);
        map.put(ArmorItem.Type.HELMET,11);
    });
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type,Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionFunctionForType, int enchantmentValue, SoundEvent sound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionFunctionForType = protectionFunctionForType;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    public int getDurabilityForType(ArmorItem.Type pType){
        return HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type pType){return this.protectionFunctionForType.get(pType);}

    public int getEnchantmentValue(){return this.enchantmentValue;}

    public SoundEvent getEquipSound(){return this.sound;}

    public Ingredient getRepairIngredient(){return this.repairIngredient.get();}

    public String getName(){
        return IronExpansion.MOD_ID + ":" + this.name;
    }

    public float getToughness(){return this.toughness;}

    public float getKnockbackResistance(){
        return this.knockbackResistance;
    }
}
