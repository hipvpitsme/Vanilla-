package plus.vanilla.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.OptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import plus.vanilla.settings.VanPlusOptions;

@Mixin(OptionsScreen.class)
public class OptionsScreenMixin extends Screen {
    protected OptionsScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "init()V")
    protected void init(CallbackInfo info) {
        addButton(new ButtonWidget(this.width / 2 + 5, this.height / 6 + 120 - 6 + 20 + 4, 150, 20, new TranslatableText("options.vanplus.title"), (buttonWidget)->{
            MinecraftClient.getInstance().openScreen(new VanPlusOptions(this));
        }));
    }
}