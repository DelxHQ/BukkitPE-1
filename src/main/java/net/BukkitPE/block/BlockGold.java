package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.utils.BlockColor;

/**
 * author: Angelic47
 * BukkitPE Project
 */
public class BlockGold extends BlockSolid {


    public BlockGold() {
        this(0);
    }

    public BlockGold(int meta) {
        super(meta);
    }

    @Override
    public int getId() {
        return GOLD_BLOCK;
    }

    @Override
    public String getName() {
        return "Gold Block";
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public double getHardness() {
        return 3;
    }

    @Override
    public double getResistance() {
        return 30;
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() >= ItemTool.TIER_IRON) {
            return new int[][]{new int[]{Item.GOLD_BLOCK, 0, 1}};
        } else {
            return new int[0][];
        }
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.GOLD_BLOCK_COLOR;
    }
}
