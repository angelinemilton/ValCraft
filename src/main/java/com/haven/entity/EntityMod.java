package com.haven.entity;

import com.haven.entity.horsey.HorseyEntity;
import com.haven.entity.horsey.HorseyRenderFactory;
import com.haven.entity.zombo.ZomboEntity;
import com.haven.entity.zombo.ZomboRenderFactory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityMod {

    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event){
        event.getRegistry().register(ZomboEntity.TYPE);
        event.getRegistry().register(HorseyEntity.TYPE);
    }
    @SubscribeEvent
    public static void registerEntityEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(ZomboEntity.EGG);
        event.getRegistry().register(HorseyEntity.HorseyEGG);
    }
    @SubscribeEvent
    public static void entityRenderers(final EntityRenderersEvent.RegisterRenderers event){
        event.registerEntityRenderer(ZomboEntity.TYPE, ZomboRenderFactory.INSTANCE);
        event.registerEntityRenderer(HorseyEntity.TYPE, HorseyRenderFactory.INSTANCE);

    }

    // this is different than in 1.16 but everything else is the same
    // I do think this makes more sense than the other way but alas change is usually hard.
    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(ZomboEntity.TYPE, ZomboEntity.createAttributes().build());
        event.put(HorseyEntity.TYPE, HorseyEntity.createAttributes().build());
    }

}
