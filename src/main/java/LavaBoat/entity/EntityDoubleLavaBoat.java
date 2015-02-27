package LavaBoat.entity;

import net.minecraft.block.material.Material;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

/*
 * LavaBoat mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityDoubleLavaBoat extends EntityDoubleBoat {

    public EntityDoubleLavaBoat(World world) {
        super(world);
        this.isImmuneToFire = true;
    }

    public EntityDoubleLavaBoat(World world, double x, double y, double z) {
        this(world);
        this.setPosition(x + 0.5, y + this.getYOffset() + 1, z + 0.5);
        this.motionX = 0;
        this.motionY = 0;
        this.motionZ = 0;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;

        this.petSeat.setStartParams(x, y, z);
    }

    /**
     * Returns the Y offset from the entity's position for any entity riding
     * this one.
     */
    @Override
    public double getMountedYOffset() {
        return 0.75;
    }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource damageSource, float par2) {
        return attackEntityFrom(damageSource, 4, par2);
    }

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate() {
        super.onUpdate();

        onUpdate(Material.lava, -0.4);
    }

    @Override
    protected EnumParticleTypes getParticles() {
        return EnumParticleTypes.LAVA;
    }
}