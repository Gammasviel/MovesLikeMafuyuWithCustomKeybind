package com.mafuyu404.moveslikemafuyu;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// 关键注解：告诉Forge这个类只在客户端加载，并且监听MOD事件总线
@Mod.EventBusSubscriber(modid = MovesLikeMafuyu.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class Keybinds {

    // 将按键定义移到这里
    public static KeyMapping customActionKey;

    // 将按键注册的逻辑也移到这里
    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        customActionKey = new KeyMapping(
                "key.moveslikemafuyu.custom_action",
                InputConstants.Type.KEYSYM,
                InputConstants.KEY_X,
                "category.moveslikemafuyu.keys"
        );
        event.register(customActionKey);
    }
}