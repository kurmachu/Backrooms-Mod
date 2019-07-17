package corp.kamabo.thebackrooms.world;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nullable;

public class BackroomGeneration {

    public static final String BACKROOM_WORLD_NAME = "backrooms";
    public static final int BACKROOM_WORLD_ID = findFreeDimensionID();
    public static final DimensionType BACKROOM_DIM_TYPE = DimensionType.register(BACKROOM_WORLD_NAME, "_"+BACKROOM_WORLD_NAME, BACKROOM_WORLD_ID, BackroomWorldProvider.class, true);
    public static final WorldType BACKROOM_WOLRD_TYPE = new BackroomWorldType(BACKROOM_WORLD_NAME); // although instance isn't used, must create the instance to register the WorldType
//    public static final IVillageCreationHandler CLOUD_VILLAGE_HANDLER = new VillageHouseCloudCreationHandler();


    public static void init(){
        DimensionManager.registerDimension(BACKROOM_WORLD_ID, BACKROOM_DIM_TYPE);
//        GameRegistry.registerWorldGenerator( , 10);
    }

    //Stolen code yeet
    @Nullable
    private static Integer findFreeDimensionID()
    {
        for (int i=2; i<Integer.MAX_VALUE; i++)
        {
            if (!DimensionManager.isDimensionRegistered(i))
            {
                // DEBUG
                System.out.println("Found free dimension ID = "+i);
                return i;
            }
        }

        // DEBUG
        System.out.println("ERROR: Could not find free dimension ID");
        return null;
    }
}
