package com.haven.item;

import com.haven.ModSoundEvents;
import com.haven.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EeveeItem extends Item {

    private static final Properties props = new Properties().tab(CreativeModeTab.TAB_DECORATIONS);
    public static Item INSTANCE = new EeveeItem(props).setRegistryName("eevee_is_da_best");

    public EeveeItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {

        ItemStack itemstack = playerIn.getItemInHand(handIn);

        BlockPos blockPos = Utils.getBlockAtCursor(playerIn, 1000.0d, true);

        if (blockPos != null){
            playerIn.playSound(ModSoundEvents.EEVEE.get(),1,1);
        }

        return InteractionResultHolder.pass(itemstack);
    }
}
