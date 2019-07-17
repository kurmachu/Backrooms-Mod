package corp.kamabo.thebackrooms.block;

import corp.kamabo.thebackrooms.BackroomMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockWallpaperWall extends Block {

    public BlockWallpaperWall() {
        super(Material.WOOD);
        setSoundType(SoundType.WOOD);
        setRegistryName("wall");
        setUnlocalizedName("wall");
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
        list.add("The distastefully decorated walls than confine you to this hell.");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return false;
    }
}
