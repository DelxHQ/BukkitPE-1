package net.BukkitPE.raknet.protocol.packet;

import net.BukkitPE.raknet.RakNet;
import net.BukkitPE.raknet.protocol.Packet;

import java.net.InetSocketAddress;

/**

 * BukkitPE Project
 */
public class OPEN_CONNECTION_REPLY_2 extends Packet {
    public static byte ID = (byte) 0x08;

    @Override
    public byte getID() {
        return ID;
    }

    public long serverID;
    public String clientAddress;
    public int clientPort;
    public short mtuSize;

    @Override
    public void encode() {
        super.encode();
        this.put(RakNet.MAGIC);
        this.putLong(this.serverID);
        this.putAddress(this.clientAddress, this.clientPort);
        this.putShort(this.mtuSize);
        this.putByte((byte) 0); //server security
    }

    @Override
    public void decode() {
        super.decode();
        this.offset += 16; //skip magic bytes
        this.serverID = this.getLong();
        InetSocketAddress address = this.getAddress();
        this.clientAddress = address.getHostString();
        this.clientPort = address.getPort();
        this.mtuSize = this.getSignedShort();
    }

    public static final class Factory implements Packet.PacketFactory {

        @Override
        public Packet create() {
            return new OPEN_CONNECTION_REPLY_2();
        }

    }
}
