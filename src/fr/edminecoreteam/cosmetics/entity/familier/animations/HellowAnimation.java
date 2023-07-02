package fr.edminecoreteam.cosmetics.entity.familier.animations;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;

import fr.edminecoreteam.cosmetics.Main;


public class HellowAnimation 
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
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 0L);
        for (Player player : Bukkit.getOnlinePlayers())
        {
              player.playSound(aS.getLocation(), Sound.VILLAGER_IDLE, 0.05f, 1.0f);
        }
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 3L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(20.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 6L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(40.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 9L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(20.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 12L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 15L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(360.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 18L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 21L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(340.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 24L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(320.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 27L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(340.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 30L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 33L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 36L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 55L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(2.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(30.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(336.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(336.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 57L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(4.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(44.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(324.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(320.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(4.0)));
            }
        }.runTaskLater((Plugin)main, 60L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(4.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(44.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(300.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
            }
        }.runTaskLater((Plugin)main, 62L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(4.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(70.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(280.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(15.0)));
            }
        }.runTaskLater((Plugin)main, 64L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(5.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(120.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(250.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(25.0)));
            }
        }.runTaskLater((Plugin)main, 66L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(5.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(155.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(250.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(28.0)));
                for (Player player : Bukkit.getOnlinePlayers())
                {
                      player.playSound(aS.getLocation(), Sound.VILLAGER_YES, 0.05f, 1.0f);
                }
            }
            
        }.runTaskLater((Plugin)main, 68L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(5.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(135.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(250.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(35.0)));
            }
        }.runTaskLater((Plugin)main, 69L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(5.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(115.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(250.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(40.0)));
            }
        }.runTaskLater((Plugin)main, 70L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(5.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(135.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(250.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(35.0)));
            }
        }.runTaskLater((Plugin)main, 70L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(5.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(155.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(250.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(28.0)));
            }
        }.runTaskLater((Plugin)main, 71L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(5.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(135.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(250.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(35.0)));
            }
        }.runTaskLater((Plugin)main, 72L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(5.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(115.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(250.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(40.0)));
            }
        }.runTaskLater((Plugin)main, 73L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(5.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(135.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(250.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(35.0)));
            }
        }.runTaskLater((Plugin)main, 74L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(5.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(155.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(250.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(28.0)));
            }
        }.runTaskLater((Plugin)main, 75L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(5.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(120.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(250.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(25.0)));
            }
        }.runTaskLater((Plugin)main, 77L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(4.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(70.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(280.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(15.0)));
            }
        }.runTaskLater((Plugin)main, 79L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(4.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(44.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(315.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(300.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
            }
        }.runTaskLater((Plugin)main, 81L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(4.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(44.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(324.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(320.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(4.0)));
            }
        }.runTaskLater((Plugin)main, 83L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(2.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(30.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(336.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(10.0), Math.toRadians(10.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(336.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 85L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 87L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
            }
        }.runTaskLater((Plugin)main, 89L);
        new BukkitRunnable() {
            int t = 0;
            
            public void run() {
                ++this.t;
                if (this.t == 0) {
                    aS.setBodyPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                }
                aS.setRightArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(10.0)));
                aS.setLeftArmPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(350.0)));
                aS.setRightLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(8.0), Math.toRadians(0.0)));
                aS.setLeftLegPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(350.0), Math.toRadians(0.0)));
                aS.setHeadPose(new EulerAngle(Math.toRadians(0.0), Math.toRadians(0.0), Math.toRadians(0.0)));
                HellowAnimation.start(aS);
                this.cancel();
            }
        }.runTaskLater((Plugin)main, 125L);
    }
}
