package fr.edminecoreteam.cosmetics.entity.familier.animations;

import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import fr.edminecoreteam.cosmetics.Main;


public class WalkAnimation 
{
	private static Main main = Main.getInstance();
	
	public static void start(ArmorStand aS) {
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 0L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(1.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(15.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(342.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(352.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(18.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(356.0)));
            }
        }.runTaskLater((Plugin)main, 2L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(1.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(28.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(330.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(336.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(22.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(352.0)));
            }
        }.runTaskLater((Plugin)main, 4L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(2.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(42.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(317.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(321.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(38.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(346.0)));
            }
        }.runTaskLater((Plugin)main, 6L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(1.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(28.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(330.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(336.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(22.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(352.0)));
            }
        }.runTaskLater((Plugin)main, 8L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(1.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(15.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(342.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(352.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(18.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(356.0)));
            }
        }.runTaskLater((Plugin)main, 10L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 12L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(359.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(350.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(14.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(12.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(348.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(8.0)));
            }
        }.runTaskLater((Plugin)main, 14L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(359.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(332.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(30.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(28.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(330.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(12.0)));
            }
        }.runTaskLater((Plugin)main, 16L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(358.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(319.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(44.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(38.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(315.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(18.0)));
            }
        }.runTaskLater((Plugin)main, 18L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(359.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(332.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(30.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(28.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(330.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(12.0)));
            }
        }.runTaskLater((Plugin)main, 20L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(359.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(350.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(14.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(12.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(348.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(8.0)));
            }
        }.runTaskLater((Plugin)main, 22L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(359.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(350.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(14.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(12.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(348.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(8.0)));
                WalkAnimation.start(aS);
                cancel();
            }
        }.runTaskLater((Plugin)main, 24L);
    }
}
