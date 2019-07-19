package corp.kamabo.thebackrooms.block;

import corp.kamabo.thebackrooms.BackroomMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPebble extends Block {
    public static final PropertyDirection FACING = BlockDirectional.FACING;

    public BlockPebble() {
        super(Material.ROCK);
        setRegistryName("pebbles");
        setUnlocalizedName("pebbles");
        setSoundType(SoundType.STONE);
        setHarvestLevel("pickaxe", 1);
//        setHardness(5000f);
//        setResistance(5000f);
        setLightLevel(0F);
        setLightOpacity(0);
        setCreativeTab(BackroomMod.creativeTab);
//        setBlockUnbreakable();
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
//        switch ((EnumFacing) state.getValue(BlockDirectional.FACING)) {
//            case SOUTH :
//            default :
//                return new AxisAlignedBB(0.3D, 0.5D, 1D, 0D, 1D, 0D);
//            case NORTH :
//                return new AxisAlignedBB(0.7D, 0.5D, 0D, 1D, 1D, 1D);
//            case WEST :
//                return new AxisAlignedBB(0D, 0.5D, 0.3D, 1D, 1D, 0D);
//            case EAST :
//                return new AxisAlignedBB(1D, 0.5D, 0.7D, 0D, 1D, 1D);
//            case UP :
//                return new AxisAlignedBB(0.7D, 1D, 0.5D, 1D, 0D, 1D);
//            case DOWN :
//                return new AxisAlignedBB(0.7D, 0D, 0.5D, 1D, 1D, 0D);
//        }
        return new AxisAlignedBB(1D, 1D, 1D, 0D, 0D, 0D);
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
        return this.getDefaultState().withProperty(FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer));
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
}