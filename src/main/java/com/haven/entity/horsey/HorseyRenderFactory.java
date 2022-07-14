package com.haven.entity.horsey;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HorseRenderer;
import net.minecraft.world.entity.animal.horse.*;

public class HorseyRenderFactory implements EntityRendererProvider<Horse> {

    public static HorseyRenderFactory INSTANCE = new HorseyRenderFactory();

    @Override
    public EntityRenderer<Horse> create(Context manager) {

        return new HorseyRenderer(manager);
    }
}
