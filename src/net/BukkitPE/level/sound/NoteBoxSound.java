package net.BukkitPE.level.sound;

import net.BukkitPE.math.Vector3;
import net.BukkitPE.network.protocol.BlockEventPacket;
import net.BukkitPE.network.protocol.DataPacket;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */

public class NoteBoxSound extends GenericSound {

    private int instrument;
    private int pitch;

    public static int INSTRUMENT_PIANO = 0;
    public static int INSTRUMENT_BASS_DRUM = 1;
    public static int INSTRUMENT_CLICK = 2;
    public static int INSTRUMENT_TABOUR = 3;
    public static int INSTRUMENT_BASS = 4;

    public NoteBoxSound(Vector3 pos) {
        this(pos, 0);
    }

    public NoteBoxSound(Vector3 pos, int instrument) {
        this(pos, instrument, 0);
    }

    public NoteBoxSound(Vector3 pos, int instrument, int pitch) {
        super(pos, instrument, pitch);
        this.instrument = instrument;
        this.pitch = pitch;
    }

    @Override
    public DataPacket[] encode() {
        BlockEventPacket pk = new BlockEventPacket();
        pk.x = (int) this.x;
        pk.y = (int) this.y;
        pk.z = (int) this.z;
        pk.case1 = this.instrument;
        pk.case2 = this.pitch;

        return new DataPacket[]{pk};
    }
}
