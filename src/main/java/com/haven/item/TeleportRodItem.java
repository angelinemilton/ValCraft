package com.haven.item;

import com.haven.ModSoundEvents;
import com.haven.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TeleportRodItem extends Item {

    //static instance for registration
    private static Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_MISC);
    public static Item INSTANCE = new TeleportRodItem(properties).setRegistryName("teleportrod");

    //constructor
    public TeleportRodItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {

        ItemStack itemstack = playerIn.getItemInHand(handIn);
        playerIn.playSound(ModSoundEvents.LOVE.get(), 1, 1);
        BlockPos blockPos = Utils.getBlockAtCursor(playerIn, 1000.0d, true);

        if (blockPos != null){
            playerIn.teleportTo(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            playerIn.fallDistance = 0.0F;
            playerIn.playSound(SoundEvents.CHICKEN_STEP,1,1);
        }

        return InteractionResultHolder.pass(itemstack);
    }
}



