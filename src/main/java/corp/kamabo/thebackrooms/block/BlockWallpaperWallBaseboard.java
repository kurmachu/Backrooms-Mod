package corp.kamabo.thebackrooms.block;

import corp.kamabo.thebackrooms.BackroomMod;
import corp.kamabo.thebackrooms.item.BackroomItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid=BackroomMod.MODID)
public class BlockWallpaperWallBaseboard extends Block {
    public BlockWallpaperWallBaseboard() {
        super(Material.WOOD);
        setSoundType(SoundType.WOOD);
        setRegistryName("wallwithbaseboard");
        setUnlocalizedName("wallwithbaseboard");
        //setHarvestLevel("pickaxe", 1);
        setHardness(2F);
        setResistance(5000f);
        setLightLevel(0F);
        setLightOpacity(255);
        setCreativeTab(BackroomMod.creativeTab);
        //setBlockUnbreakable();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        list.add("Stubbing your toe on these gives you enough pain to feel alive again.");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        //super.onBlockDestroyedByPlayer(worldIn, pos, state);
        worldIn.setBlockState(pos,BackroomBlocks.blockWallpaperWallBaseboardBroken.getDefaultState());
    }

    @SubscribeEvent
    public static void onBreakEvent(BlockEvent.BreakEvent event) {
        if(event.getState().getBlock().equals(BackroomBlocks.blockWallpaperWallBaseboard)){
            if(!event.getPlayer().isCreative()){
                event.getPlayer().inventory.addItemStackToInventory(new ItemStack(BackroomItems.itemBaseboard));
            }else if (event.getPlayer().isCreative()){
                //event.getWorld().setBlockState(event.getPos(),BackroomBlocks.blockWallpaperWall.getDefaultState());
                event.getWorld().setBlockToAir(event.getPos());
            }
        }
    }


    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return null;
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return false;
    }


}
