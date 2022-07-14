package com.haven.entity.oceanpiggy;

import com.haven.BaseMod;
import com.haven.entity.EntityUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowBoatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class OceanPiggyEntity extends Pig {

    public static EntityType<OceanPiggyEntity> TYPE = (EntityType<OceanPiggyEntity>) EntityType.Builder.of(OceanPiggyEntity::new, MobCategory.MONSTER)
            .build("oceanpiggy")
            .setRegistryName(BaseMod.MODID, "oceanpiggy");

    //edit primary and secondary colors for egg
    public static Item PigEGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0xb00101, 0xacbf1f);

    public OceanPiggyEntity(EntityType<? extends Pig> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return AmbientCreature.createMobAttributes()
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 1)
                .add(Attributes.MOVEMENT_SPEED, 10)
                .add(Attributes.FOLLOW_RANGE, 10);
    }

    @Override
    public void registerGoals() {
        this.targetSelector.addGoal(0, new FloatGoal(this));
        this.targetSelector.addGoal(1, new FollowBoatGoal(this));
        this.targetSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(6, new RandomSwimmingGoal(this, 1, 2));
       
    }

}
