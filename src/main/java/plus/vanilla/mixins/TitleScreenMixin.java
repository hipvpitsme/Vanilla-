package plus.vanilla.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;

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
                }));
        this.addButton(new ButtonWidget(this.width / 2 + 2, j + spacingY * 2, 98, 20,
                new TranslatableText("menu.coraldiscord"), (buttonWidget) -> {
                    Util.getOperatingSystem().open("https://discord.gg/8CM98Zc");
                }
            )
        );
    }

    @Inject(at = @At("RETURN"), method = "initWidgetsNormal()V", cancellable = true)
    private void initWidgetsNormal(int y, int spacingY, CallbackInfo info) {
        for(AbstractButtonWidget b : buttons){
            if(b.getMessage().toString().contains("menu.multiplayer")){
                b.setWidth(98);
            }
            if(b.getMessage().toString().contains("menu.online")){
                b.setWidth(98);
            }
        }
    }
}