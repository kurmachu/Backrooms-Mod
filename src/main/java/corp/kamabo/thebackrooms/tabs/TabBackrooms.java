package corp.kamabo.thebackrooms.tabs;

import corp.kamabo.thebackrooms.BackroomMod;
import corp.kamabo.thebackrooms.block.BackroomBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TabBackrooms extends CreativeTabs {

    public TabBackrooms(){
        super(BackroomMod.MODID + ".backroomstab");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(BackroomBlocks.blockWallpaperWall);
    }
}
