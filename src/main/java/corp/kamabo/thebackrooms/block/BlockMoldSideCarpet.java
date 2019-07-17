package corp.kamabo.thebackrooms.block;

import corp.kamabo.thebackrooms.BackroomMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class BlockMoldSideCarpet extends Block {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockMoldSideCarpet() {
        super(Material.ROCK);
        setRegistryName("moldsidecarpet");
        setUnlocalizedName("moldsidecarpet");
        setSoundType(SoundType.CLOTH);
        setHarvestLevel("pickaxe", 1);
        setHardness(5000f);
        setResistance(5000f);
        setLightLevel(0F);
        setLightOpacity(255);
        setCreativeTab(BackroomMod.creativeTab);
        setBlockUnbreakable();
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        list.add("Be mindful not to step in it.");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

    @Override
    protected net.minecraft.block.state.BlockStateContainer createBlockState() {
        return new net.minecraft.block.state.BlockStateContainer(this, new IProperty[]{FACING});
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing) state.getValue(FACING)).getIndex();
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta,
                                            EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
    }
}
