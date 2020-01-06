package corp.kamabo.thebackrooms.block.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BackroomMatertial extends Material{
    public static final Material PEBBLE = new BackroomMatertial(MapColor.AIR).setSolidOverride(true);

    public BackroomMatertial(MapColor color) {
        super(color);
    }

    public BackroomMatertial setSolidOverride(boolean in){
        o_solid = in;
        return this;
    }

    private boolean o_solid;

    @Override
    public boolean isSolid() {
        return o_solid;
    }
}
