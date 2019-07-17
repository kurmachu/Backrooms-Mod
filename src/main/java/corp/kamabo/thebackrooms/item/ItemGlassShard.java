package corp.kamabo.thebackrooms.item;

import com.google.common.collect.Multimap;
import corp.kamabo.thebackrooms.BackroomMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemGlassShard extends ItemSword {

    public ItemGlassShard(){
        super(BackroomItems.GLASSSHARD);
        setUnlocalizedName("glassshard");
        setRegistryName("glassshard");
        setCreativeTab(BackroomMod.creativeTab);
    }
}
