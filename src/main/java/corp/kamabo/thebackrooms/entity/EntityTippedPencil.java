package corp.kamabo.thebackrooms.entity;

import corp.kamabo.thebackrooms.item.BackroomItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionUtils;
import net.minecraft.world.World;

public class EntityTippedPencil extends EntityTippedArrow {

    public EntityTippedPencil(World world1, EntityLivingBase entityLivingBase){
        super(world1,entityLivingBase);
    }
    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(BackroomItems.itemPencil);
    }
}
