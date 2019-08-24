package corp.kamabo.thebackrooms.item;

import corp.kamabo.thebackrooms.BackroomMod;
import corp.kamabo.thebackrooms.entity.EntityTippedPencil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPencil extends Item {
    public ItemPencil(){
        setUnlocalizedName("pencil");
        setRegistryName("pencil");
        setCreativeTab(BackroomMod.creativeTab);
    }

    public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
        EntityTippedPencil entitytippedarrow = new EntityTippedPencil(worldIn, shooter);
        return entitytippedarrow;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == ItemPencil.class;
    }
}
