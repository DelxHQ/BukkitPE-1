package net.BukkitPE.item;


import net.BukkitPE.block.BlockBrewingStand;

public class ItemBrewingStand extends Item {

    public ItemBrewingStand(int meta) {
        this(meta, 1);
    }

    public ItemBrewingStand(int meta, int count) {
        super(BREWING_STAND, 0, count, "Brewing Stand");
        this.block = new BlockBrewingStand();
    }

}