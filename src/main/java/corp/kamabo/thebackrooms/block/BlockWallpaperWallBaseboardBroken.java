package corp.kamabo.thebackrooms.block;

import corp.kamabo.thebackrooms.BackroomMod;
import corp.kamabo.thebackrooms.item.BackroomItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
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

public class BlockWallpaperWallBaseboardBroken extends Block {
    public BlockWallpaperWallBaseboardBroken() {
        super(Material.WOOD);
        setSoundType(SoundType.WOOD);
        setRegistryName("wallwithbaseboardbroken");
        setUnlocalizedName("wallwithbaseboardbroken");
        //setHarvestLevel("pickaxe", 1);
        setHardness(5000f);
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
        //list.add("Stubbing your toe on these gives you enough pain to feel alive again.");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.SOLID;
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
