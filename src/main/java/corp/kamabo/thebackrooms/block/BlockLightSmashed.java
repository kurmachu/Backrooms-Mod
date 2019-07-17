package corp.kamabo.thebackrooms.block;

import corp.kamabo.thebackrooms.BackroomMod;
import corp.kamabo.thebackrooms.block.tile.TileEntityBuzz;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BlockLightSmashed extends Block {

    public BlockLightSmashed() {
        super(Material.GLASS);
        setSoundType(SoundType.GLASS);
        setRegistryName("lightsmash");
        setUnlocalizedName("lightsmash");
        setHarvestLevel("pickaxe", 1);
        setHardness(5000f);
        setResistance(5000f);
        //setLightLevel(1F);
        setLightOpacity(255);
        setCreativeTab(BackroomMod.creativeTab);
        setBlockUnbreakable();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        list.add("Don't cut your hand.");
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
