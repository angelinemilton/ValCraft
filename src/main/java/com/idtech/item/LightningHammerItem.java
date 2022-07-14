package com.idtech.item;

import com.idtech.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class LightningHammerItem extends Item {

    private static Properties properties = new Properties().tab(CreativeModeTab.TAB_MISC);
    public static Item INSTANCE = new LightningHammerItem(properties).setRegistryName("lightninghammer");

    public LightningHammerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
        //get the item held in hand
        ItemStack itemstack = playerIn.getItemInHand(handIn);

        //get cursor position
        BlockPos location = Utils.getBlockAtCursor(playerIn, 20.0d, true);

        //set explosion radius
        float explosionRadius = 10.0f;


        if (location != null) {
            Utils.createExplosion(level, location, explosionRadius); //explosion
            Utils.strikeLightning(level,location); //lightning
            Utils.setFireBlock(level, location, Direction.UP); //set block on fire


        }

        //return successful
        return InteractionResultHolder.pass(itemstack);

    }
}
