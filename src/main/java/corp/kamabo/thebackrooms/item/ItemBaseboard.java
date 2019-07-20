package corp.kamabo.thebackrooms.item;

import corp.kamabo.thebackrooms.BackroomMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBaseboard extends Item {
    public ItemBaseboard(){
        setUnlocalizedName("baseboard");
        setRegistryName("baseboard");
        setCreativeTab(BackroomMod.creativeTab);
    }

    @Override
    public int getItemBurnTime(ItemStack itemStack) {
        return 400;
    }
}
