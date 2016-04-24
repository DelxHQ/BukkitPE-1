package net.BukkitPE.raknet.protocol.packet;

import net.BukkitPE.raknet.protocol.Packet;

/**
 * author: MagicDroidX
 * BukkitPE Project
 */
public class PONG_DataPacket extends Packet {
    public static byte ID = (byte) 0x03;

    @Override
    public byte getID() {
        return ID;
    }

    public long pingID;

    @Override
    public void encode() {
        super.encode();
        this.putLong(this.pingID);
    }

    @Override
    public void decode() {
        super.decode();
        this.pingID = this.getLong();
    }

    public static final class Factory implements Packet.PacketFactory {

        @Override
        public Packet create() {
            return new PONG_DataPacket();
        }

    }
}
