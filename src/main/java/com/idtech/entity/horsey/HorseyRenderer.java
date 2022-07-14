package com.idtech.entity.horsey;

import com.idtech.BaseMod;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.horse.*;
import org.jetbrains.annotations.NotNull;

public class HorseyRenderer extends EntityRenderer<Horse> {


    protected HorseyRenderer(EntityRendererProvider.Context manager) {
        super(manager);
    }


    @Override
    public ResourceLocation getTextureLocation(Horse entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/horsey.png");
    }
}
