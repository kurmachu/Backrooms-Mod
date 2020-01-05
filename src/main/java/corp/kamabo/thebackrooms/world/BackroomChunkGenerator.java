package corp.kamabo.thebackrooms.world;

import com.sun.javafx.iio.ImageStorage;
import corp.kamabo.thebackrooms.block.BackroomBlocks;
import corp.kamabo.thebackrooms.block.BlockPebble;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import org.lwjgl.Sys;

import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class BackroomChunkGenerator implements IChunkGenerator {
    private World world;
    BufferedImage image;
    Random random = new Random(System.currentTimeMillis());

    protected ChunkPrimer chunkPrimer = new ChunkPrimer();
    BackroomChunkGenerator(World worldIn){
        System.out.println(new File("layout.png").getAbsolutePath());
        try{
            image = ImageIO.read(new File("layout.png"));
        } catch (IOException e) {
            e.printStackTrace();
            image = new BufferedImage(100,100, BufferedImage.TYPE_INT_RGB);
        }
        world = worldIn;
    }
    private boolean imagePosValid(int x, int y){
        //System.out.println(x+":"+y);
        if(x>=image.getWidth()){
            return false;
        }
        if(y>=image.getHeight()){
            return false;
        }
        if(x<0||y<0){
            return false;
        }
        return true;
    }
    @Override
    public Chunk generateChunk(int x, int z) {
        chunkPrimer = new ChunkPrimer();
        for (int localX = 0; localX < 16; localX++) {
            for (int localZ = 0; localZ < 16; localZ++) {
                //System.out.println("die:"+localX+":"+localZ);
                int imagex = ((x*16)+localX)+(image.getWidth()/2);
                int imagey = ((z*16)+localZ)+(image.getWidth()/2);
                if(imagePosValid(imagex,imagey)){
                    chunkPrimer.setBlockState(localX,0,localZ,BackroomBlocks.blockYellowCarpet.getDefaultState());
                    chunkPrimer.setBlockState(localX,5,localZ,BackroomBlocks.blockCeiling.getDefaultState());
                    int clr = image.getRGB(imagex,imagey);
//                    System.out.println(clr+":"+imagex+":"+imagey);
                    if(clr-(-5111553)==0){
                        if(random.nextInt(100)<1){
                            chunkPrimer.setBlockState(localX,1,localZ,BackroomBlocks.blockPebble.getDefaultState().withProperty(BlockPebble.FACING, EnumFacing.fromAngle(random.nextDouble()*360)));
                        }
                    }else if (clr-(-12058369)==0){
                        chunkPrimer.setBlockState(localX,1,localZ,BackroomBlocks.blockWallpaperWallBaseboard.getDefaultState());
                        chunkPrimer.setBlockState(localX,2,localZ,BackroomBlocks.blockWallpaperWall.getDefaultState());
                        chunkPrimer.setBlockState(localX,3,localZ,BackroomBlocks.blockWallpaperWall.getDefaultState());
                        chunkPrimer.setBlockState(localX,4,localZ,BackroomBlocks.blockWallpaperWall.getDefaultState());
                    }else if (clr-(-65316)==0){
                        chunkPrimer.setBlockState(localX,5,localZ,BackroomBlocks.blockLight.getDefaultState());
                    }else if (clr-(-1806430)==0){
                        chunkPrimer.setBlockState(localX,5,localZ,BackroomBlocks.blockLightDirty.getDefaultState());
                    }
                }
            }
        }

        Chunk chunk = new Chunk(world,chunkPrimer,x,z);
        chunk.generateSkylightMap();
        chunk.markDirty();
//        chunk.enqueueRelightChecks();
//        chunk.resetRelightChecks();
        //chunk.enqueueRelightChecks();
        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(false, this, this.world, null, x, z, false);
//        System.out.println("ChunkZOink");
        return chunk;
    }

    @Override
    public void populate(int x, int z) {
    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int x, int z) {
        chunkIn.enqueueRelightChecks();
        return true;
    }

    @Override
    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        return null;
    }

    @Nullable
    @Override
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored) {
        return null;
    }

    @Override
    public void recreateStructures(Chunk chunkIn, int x, int z) {

    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
        return false;
    }
}
