package plus.vanilla.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.GameRenderer;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
    @Inject(at = @At("RETURN"), method = "render()V")
    public void render(float tickDelta, long startTime, boolean tick, CallbackInfo info) {
        // MinecraftClient mc = MinecraftClient.getInstance();
        // if(MinecraftClient.isHudEnabled()){
        //     InGameHud hud = mc.inGameHud;
        //     if(hud != null){
        //         // ClientPlayerEntity player = mc.player;
        //         // double px = player.getX();
        //         // double py = player.getY();
        //         // double pz = player.getZ();
        //         int width = mc.getWindow().getScaledWidth();
        //         int height = mc.getWindow().getScaledHeight();
        //         hud.getFontRenderer().draw("Position", 0, height, 0x7FFFFFFF, false, null, null, false, 0, 15728880);
        //     }
        // }
    }
}