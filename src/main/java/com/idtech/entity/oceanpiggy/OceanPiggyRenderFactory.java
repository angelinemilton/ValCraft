package com.idtech.entity.oceanpiggy;

import com.idtech.entity.horsey.HorseyRenderFactory;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.PigRenderer;
import net.minecraft.world.entity.animal.Pig;

public class OceanPiggyRenderFactory implements EntityRendererProvider<Pig> {
    public static HorseyRenderFactory INSTANCE = new HorseyRenderFactory();
    @Override
    public EntityRenderer<Pig> create(Context manager) {
        return new PigRenderer(manager);
    }
}
