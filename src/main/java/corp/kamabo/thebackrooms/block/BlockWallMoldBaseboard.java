package corp.kamabo.thebackrooms.block;

import corp.kamabo.thebackrooms.BackroomMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockWallMoldBaseboard extends Block {
    public BlockWallMoldBaseboard() {
        super(Material.WOOD);
        setRegistryName("moldwallwithbaseboard");
        setUnlocalizedName("moldwallwithbaseboard");
        setSoundType(SoundType.WOOD);
        setHarvestLevel("pickaxe", 1);
        setHardness(5000f);
        setResistance(5000f);
        setLightLevel(0F);
        setLightOpacity(255);
        setCreativeTab(BackroomMod.creativeTab);
        setBlockUnbreakable();
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        list.add("You probably shouldn't be touching this.");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }
}
