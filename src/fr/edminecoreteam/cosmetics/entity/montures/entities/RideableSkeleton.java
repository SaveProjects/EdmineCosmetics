// 
// Decompiled by Procyon v0.5.36
// 

package fr.edminecoreteam.cosmetics.entity.montures.entities;

import net.minecraft.server.v1_8_R3.MathHelper;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.entity.Player;

import fr.edminecoreteam.cosmetics.entity.montures.MountManager;

import java.lang.reflect.Field;
import net.minecraft.server.v1_8_R3.EntitySkeleton;

public class RideableSkeleton extends EntitySkeleton
{
    protected Field FIELD_JUMP;
    private Player rider;
    
    public RideableSkeleton(final World world) {
        super(world);
        this.FIELD_JUMP = null;
    }
    
    public void g(float f, float f1) {
        if (MountManager.shouldDie((EntityLiving)this, this.rider)) {
            return;
        }
        if (this.passenger != null && this.passenger instanceof EntityHuman) {
            final float yaw = this.passenger.yaw;
            this.yaw = yaw;
            this.lastYaw = yaw;
            this.pitch = this.passenger.pitch * 0.5f;
            this.setYawPitch(this.yaw, this.pitch);
            final float yaw2 = this.yaw;
            this.aI = yaw2;
            this.aK = yaw2;
            f = ((EntityLiving)this.passenger).aZ * 0.5f;
            f1 = ((EntityLiving)this.passenger).ba;
            if (f1 <= 0.0f) {
                f1 *= 0.25f;
            }
            this.S = 1.0f;
            this.aM = this.bI() * 0.1f;
            if (!this.world.isClientSide) {
                this.k(MountManager.mountSpeed);
                super.g(f, f1);
            }
            this.aA = this.aB;
            final double d0 = this.locX - this.lastX;
            final double d2 = this.locZ - this.lastZ;
            float f2 = MathHelper.sqrt(d0 * d0 + d2 * d2) * 4.0f;
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            this.aB += (f2 - this.aB) * 0.4f;
            this.aC += this.aB;
        }
        else {
            this.S = 0.5f;
            this.aM = 0.02f;
            super.g(f, f1);
        }
    }
}
