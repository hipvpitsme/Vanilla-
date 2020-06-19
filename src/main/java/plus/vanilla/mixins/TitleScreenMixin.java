package plus.vanilla.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        int j = this.height / 4 + 48;
        int spacingY = 24;
        this.addButton(new ButtonWidget(this.width / 2 + 2, j + spacingY * 1, 98, 20,
                new TranslatableText("menu.coralserver"), (buttonWidget) -> {
                    this.client.openScreen(new ConnectScreen(new TitleScreen(), MinecraftClient.getInstance(),
                            new ServerInfo("Coral", "play.coral.bar", false)));
                }
            )
        );
    }

    @Inject(at = @At("RETURN"), method = "initWidgetsNormal()V", cancellable = true)
    private void initWidgetsNormal(int y, int spacingY, CallbackInfo info) {
        buttons.get(2).setWidth(98);
    }
}