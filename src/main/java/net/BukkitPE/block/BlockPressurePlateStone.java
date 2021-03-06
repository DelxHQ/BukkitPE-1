package net.BukkitPE.block;

import net.BukkitPE.item.Item;
import net.BukkitPE.item.ItemTool;
import net.BukkitPE.utils.BlockColor;

/**
 * @author BukkitPE Project Team
 */
public class BlockPressurePlateStone extends BlockPressurePlate {

    public BlockPressurePlateStone(int meta) {
        super(meta);
    }

    public BlockPressurePlateStone() {
        this(0);
    }

    @Override
    public String getName() {
        return "Stone Pressure Plate";
    }

    @Override
    public int getId() {
        return STONE_PRESSURE_PLATE;
    }

    @Override
    public double getHardness() {
        return 0.5D;
    }

    @Override
    public double getResistance() {
        return 2.5D;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public int[][] getDrops(Item item) {
        if (item.isPickaxe()) {
            return new int[][]{
                    {Item.STONE_PRESSURE_PLATE, 0, 1}
            };
        }
        return new int[][]{{}};
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.STONE_BLOCK_COLOR;
    }

}
