package corp.kamabo.thebackrooms.mcreator;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Block;

public class mcreator_pipesStraightLampOffRedstoneOff extends thebackrooms.ModElement {

	public mcreator_pipesStraightLampOffRedstoneOff(thebackrooms instance) {
		super(instance);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("block") == null) {
			System.err.println("Failed to load dependency block for procedure pipesStraightLampOffRedstoneOff!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure pipesStraightLampOffRedstoneOff!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure pipesStraightLampOffRedstoneOff!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure pipesStraightLampOffRedstoneOff!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure pipesStraightLampOffRedstoneOff!");
			return;
		}
		Block block = (Block) dependencies.get("block");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		block.setLightLevel((float) 0.6);
		world.notifyNeighborsOfStateChange(new BlockPos((int) x, (int) y, (int) z), world.getBlockState(new BlockPos((int) x, (int) y, (int) z))
				.getBlock(), true);
	}
}
