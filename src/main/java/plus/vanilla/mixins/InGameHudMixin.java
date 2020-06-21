package plus.vanilla.mixins;

import java.text.DecimalFormat;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import plus.vanilla.addition.settings.VanPlusOptions;

@Mixin(InGameHud.class)
public class InGameHudMixin extends DrawableHelper {
    @Inject(at = @At("RETURN"), method = "render()V")
    public void render(MatrixStack matrixStack, float f, CallbackInfo info) {
        if(VanPlusOptions.showCoords){
            MinecraftClient mc = MinecraftClient.getInstance();
            if(MinecraftClient.isHudEnabled()){
                InGameHud hud = mc.inGameHud;
                if(hud != null){
                    TextRenderer textRenderer = hud.getFontRenderer();
                    ClientPlayerEntity player = mc.player;
    
                    double px = player.getX();
                    double py = player.getY();
                    double pz = player.getZ();
    
                    String decimalPattern = "0.###";
                    DecimalFormat df = new DecimalFormat(decimalPattern);
    
                    //int width = mc.getWindow().getScaledWidth();
                    int height = mc.getWindow().getScaledHeight();
                    int fontHeight = textRenderer.fontHeight;
                    textRenderer.draw(matrixStack, "X: "+df.format(px), 0, height-(fontHeight*3), 0xFFFFFFFF);
                    textRenderer.draw(matrixStack, "Y: "+df.format(py), 0, height-(fontHeight*2), 0xFFFFFFFF);
                    textRenderer.draw(matrixStack, "Z: "+df.format(pz), 0, height-(fontHeight*1), 0xFFFFFFFF);
                }
            }
        }
    }
}