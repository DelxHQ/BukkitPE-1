package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;

/**
 * Created on 2015/11/24 by xtypr.
 * Package net.BukkitPE.block in project BukkitPE .
 */
public class BlockCoal extends BlockSolid {
    public BlockCoal() {
        this(0);
    }

    public BlockCoal(int meta) {
        super(0);
    }

    @Override
    public int getId() {
        return COAL_BLOCK;
    }

    @Override
    public double getHardness() {
        return 5;
    }

    @Override
    public double getResistance() {
        return 30;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int getBurnChance() {
        return 5;
    }

    @Override
    public int getBurnAbility() {
        return 5;
    }

    @Override
    public String getName() {
        return "Coal Block";
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isPickaxe()) {
            return new int[][]{
                    {Item.COAL_BLOCK, 0, 1}
            };
        } else {
            return new int[0][];
        }
    }
}
