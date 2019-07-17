package corp.kamabo.thebackrooms.tabs;

import corp.kamabo.thebackrooms.BackroomMod;
import corp.kamabo.thebackrooms.block.BackroomBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabBackroomsNightly extends CreativeTabs {

    public TabBackroomsNightly(){
        super(BackroomMod.MODID + ".backroomstabnightly");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(BackroomBlocks.blockChair);
    }
}
