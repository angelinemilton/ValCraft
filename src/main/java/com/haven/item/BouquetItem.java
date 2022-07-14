package com.haven.item;

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
import org.lwjgl.system.CallbackI;

public class BouquetItem extends Item {

    private static final Properties props = new Properties().tab(CreativeModeTab.TAB_DECORATIONS);
    public static Item INSTANCE = new BouquetItem(props).setRegistryName("bouquet");

    public BouquetItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {

        ItemStack itemstack = playerIn.getItemInHand(handIn);

        BlockPos blockPos = Utils.getBlockAtCursor(playerIn, 1000.0d, true);

        if (blockPos != null){
            playerIn.playSound(SoundEvents.AMBIENT_UNDERWATER_ENTER,1,1);
        }

        return InteractionResultHolder.pass(itemstack);
    }

}
