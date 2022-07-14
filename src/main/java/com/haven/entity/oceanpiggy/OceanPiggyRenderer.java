package com.haven.entity.oceanpiggy;

import com.haven.BaseMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.PigRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.horse.Horse;

public class OceanPiggyRenderer extends PigRenderer {


    public OceanPiggyRenderer(EntityRendererProvider.Context p_174340_) {
        super(p_174340_);
    }

    public ResourceLocation getTextureLocation(Horse entity) {
        return new ResourceLocation(BaseMod.MODID, "textures/entity/oceanpiggy.png");
    }
}
