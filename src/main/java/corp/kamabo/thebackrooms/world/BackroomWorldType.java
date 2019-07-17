package corp.kamabo.thebackrooms.world;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.IChunkGenerator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackroomWorldType extends WorldType {
    /**
     * Creates a new world type, the ID is hidden and should not be referenced by modders.
     * It will automatically expand the underlying workdType array if there are no IDs left.
     *
     * @param name
     */
    int size;
    public BackroomWorldType(String name) {
        super(name);
        BufferedImage image;
        try{
            image = ImageIO.read(new File("layout.png"));
        } catch (IOException e) {
            e.printStackTrace();
            image = new BufferedImage(100,100, BufferedImage.TYPE_INT_RGB);
        }
        size = image.getHeight()/2;
        System.out.println("---------------World layout size:"+size);
    }

    @Override
    public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
        return new BackroomChunkGenerator(world);
    }
    @Override
    public boolean isCustomizable()
    {
        return false;
    }

    @Override
    public boolean canBeCreated() {
        return true;
    }

    @Override
    public int getMinimumSpawnHeight(World world) {
        return 0;
    }



    @Override
    public int getSpawnFuzz(WorldServer world, MinecraftServer server) {
        return size;
    }
}
