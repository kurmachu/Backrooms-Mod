package corp.kamabo.thebackrooms.block;

import corp.kamabo.thebackrooms.BackroomMod;
import corp.kamabo.thebackrooms.block.tile.TileEntityBuzz;
import corp.kamabo.thebackrooms.item.BackroomItems;
import corp.kamabo.thebackrooms.sound.BackroomSounds;
import corp.kamabo.thebackrooms.sound.LoopingSound;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid=BackroomMod.MODID)
public class BlockLight extends Block {

    public BlockLight() {
        super(Material.GLASS);
        setSoundType(SoundType.GLASS);
        setRegistryName("lighton");
        setUnlocalizedName("lighton");
        //setHarvestLevel("pickaxe", 1);
        setHardness(2f);
        setResistance(5000f);
        setLightLevel(1F);
        setLightOpacity(255);
        setCreativeTab(BackroomMod.creativeTab);
        //setBlockUnbreakable();
    }

//    @Deprecated
//    @Override
//    public boolean hasTileEntity(IBlockState state) {
//        return true;
//    }

//    @Deprecated
//    @Nullable
//    @Override
//    public TileEntity createTileEntity(World world, IBlockState state) {
//        return new TileEntityBuzz();
//    }


    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        list.add("Bzzzzzzzzzzzzzzzzzzzzzz");
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        //super.onBlockDestroyedByPlayer(worldIn, pos, state);
        worldIn.setBlockState(pos,BackroomBlocks.blockLightBroken.getDefaultState());
    }

    @SubscribeEvent
    public static void onBreakEvent(BlockEvent.BreakEvent event) {
        if(event.getState().getBlock().equals(BackroomBlocks.blockLight)){
            if(!event.getPlayer().isCreative()){
                EntityItem item = new EntityItem(event.getWorld(),event.getPos().getX()+0.5,event.getPos().getY()-0.9,event.getPos().getZ()+0.5,new ItemStack(BackroomItems.itemGlassShard));
                event.getWorld().spawnEntity(item);
                Random random = new Random(System.currentTimeMillis());
                if(random.nextInt(100)<20){
                    ItemStack egg = new ItemStack(BackroomItems.itemPencil);
                    switch (random.nextInt(5)){
                        case 0:
                            egg = new ItemStack(Items.PAPER);
                            break;
                        case 1:
                            egg = new ItemStack(Items.LEATHER);
                            break;
                        case 2:
                            egg = new ItemStack(Blocks.COBBLESTONE);
                            break;
                        case 3:
                            switch (random.nextInt(3)){
                                case 0:
                                    egg = new ItemStack(Items.GOLD_NUGGET);
                                    break;
                                case 1:
                                    egg = new ItemStack(Items.IRON_NUGGET);
                                    break;
                                case 2:
                                    egg = new ItemStack(Items.REDSTONE);
                                    break;
                            }
                            break;
                        case 4:
                            egg = new ItemStack(BackroomItems.itemPencil);
                            break;
                    }
                    EntityItem item2 = new EntityItem(event.getWorld(),event.getPos().getX()+0.5,event.getPos().getY()-0.9,event.getPos().getZ()+0.5,egg);
                    event.getWorld().spawnEntity(item2);
                }
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
