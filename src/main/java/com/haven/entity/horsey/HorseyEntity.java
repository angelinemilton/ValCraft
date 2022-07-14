package com.haven.entity.horsey;

import com.haven.BaseMod;
import com.haven.entity.EntityUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowBoatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.animal.horse.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class HorseyEntity extends Horse {

    public static EntityType<HorseyEntity> TYPE = (EntityType<HorseyEntity>) EntityType.Builder.of(HorseyEntity::new, MobCategory.MONSTER)
            .build("horsey")
            .setRegistryName(BaseMod.MODID, "horsey");

    public static Item HorseyEGG = EntityUtils.buildEntitySpawnEgg(TYPE, 0x000000, 0xFFA5B0);
    public HorseyEntity(EntityType<? extends Horse> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return AmbientCreature.createMobAttributes()
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE)
                .add(Attributes.MOVEMENT_SPEED, 100)
                .add(Attributes.FOLLOW_RANGE, 10)
                .add(Attributes.FLYING_SPEED, 100);
    }

    @Override
    public void registerGoals() {
        this.targetSelector.addGoal(0, new FloatGoal(this));
        //this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(1, new FollowBoatGoal(this));
        this.targetSelector.addGoal(8, new RandomLookAroundGoal(this));
    }

}
