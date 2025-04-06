package com.mafuyu404.moveslikemafuyu.network;

import com.mafuyu404.moveslikemafuyu.MovesLikeMafuyu;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkHandler {
    private static final String PROTOCOL = "1.0";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MovesLikeMafuyu.MODID, "sync_data"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals
    );

    // 注册数据包
    public static void register() {
        int packetId = 0;
        CHANNEL.registerMessage(packetId++, TagMessage.class, TagMessage::encode, TagMessage::decode, TagMessage::handle);
        CHANNEL.registerMessage(packetId++, KnockMessage.class, KnockMessage::encode, KnockMessage::decode, KnockMessage::handle);
        CHANNEL.registerMessage(packetId++, ConfigMessage.class, ConfigMessage::encode, ConfigMessage::decode, ConfigMessage::handle);
    }

    // 发送数据包到客户端
    public static void sendToClient(ServerPlayer player, Object packet) {
//        PrimitivePacket packet = new PrimitivePacket(key, value);
        CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }
}