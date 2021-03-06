package net.BukkitPE.event.block;

import net.BukkitPE.Player;
import net.BukkitPE.block.Block;
import net.BukkitPE.event.Cancellable;
import net.BukkitPE.event.HandlerList;
import net.BukkitPE.item.Item;

import java.util.ArrayList;
import java.util.List;

/**

 * BukkitPE Project
 */
public class BlockBreakEvent extends BlockEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    protected Player player;

    protected Item item;

    protected boolean instaBreak = false;
    protected Item[] blockDrops = new Item[0];

    public BlockBreakEvent(Player player, Block block, Item item) {
        this(player, block, item, false);
    }

    public BlockBreakEvent(Player player, Block block, Item item, boolean instaBreak) {
        super(block);
        this.item = item;
        this.player = player;
        this.instaBreak = instaBreak;
        int[][] drops = player.isSurvival() ? block.getDrops(item) : new int[0][];
        List<Item> list = new ArrayList<>();
        for (int[] i : drops) {
            list.add(Item.get(i[0], i[1], i[2]));
        }
        this.blockDrops = list.toArray(new Item[list.size()]);
    }

    public Player getPlayer() {
        return player;
    }

    public Item getItem() {
        return item;
    }

    public boolean getInstaBreak() {
        return this.instaBreak;
    }

    public Item[] getDrops() {
        return blockDrops;
    }

    public void setDrops(Item[] drops) {
        this.blockDrops = drops;
    }

    public void setInstaBreak(boolean instaBreak) {
        this.instaBreak = instaBreak;
    }

}
