package com.haven.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.system.CallbackI;

@Mod.EventBusSubscriber
public class ItemMod {

    //BASIC ITEMS
    public static final Item STRUCTURE_GEL = ItemUtils.buildBasicItem("structuregel", CreativeModeTab.TAB_MISC);
    public static final Item GEL_ORE = ItemUtils.buildBasicItem("gelore", CreativeModeTab.TAB_MISC);
    public static final Item STRAWBERRY = ItemUtils.buildBasicItem("strawberry", CreativeModeTab.TAB_MISC);

    //FOODS
    public static FoodProperties sushi = (new FoodProperties.Builder().nutrition(3).saturationMod(1.4f).effect(new MobEffectInstance(MobEffects.LUCK, 500, 1), 1.0f).alwaysEat().build());
    public static Item sushiItem = ItemUtils.buildFoodItem("sushi", sushi);

    public static FoodProperties dosaProps = (new FoodProperties.Builder().nutrition(5).saturationMod(1.4f).effect(new MobEffectInstance(MobEffects.REGENERATION, 500, 1), 1.0f).alwaysEat().build());
    public static Item dosa = ItemUtils.buildFoodItem("dosa", dosaProps);

    public static FoodProperties meenChar = (new FoodProperties.Builder().nutrition(5).saturationMod(1.4f).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 500, 1), 1.0f).alwaysEat().build());
    public static Item meenCurry = ItemUtils.buildFoodItem("meencurry", meenChar);
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        //BASIC ITEMS
        event.getRegistry().register(STRUCTURE_GEL);
        event.getRegistry().register(GEL_ORE);
        event.getRegistry().register(STRAWBERRY);

        // ITEMS
        event.getRegistry().register(TeleportRodItem.INSTANCE);
        event.getRegistry().register(LightningHammerItem.INSTANCE);
        event.getRegistry().register(BouquetItem.INSTANCE);
        event.getRegistry().register(MookiHeartItem.INSTANCE);
        event.getRegistry().register(EeveeItem.INSTANCE);
        // TOOLS

        // FOOD
        event.getRegistry().register(sushiItem);
        event.getRegistry().register(dosa);
        event.getRegistry().register(meenCurry);

        // ARMOR

        //PROJECTILES

    }
}
