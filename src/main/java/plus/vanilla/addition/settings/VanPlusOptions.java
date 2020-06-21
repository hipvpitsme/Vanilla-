package plus.vanilla.addition.settings;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

public class VanPlusOptions extends Screen {

    private final Screen parent;
    public static Boolean showCoords = true;

    public VanPlusOptions(Screen parentScreen) {
        super(new TranslatableText("options.vanplus.title"));
        this.parent = parentScreen;
    }
    
    @Override
    public void init(MinecraftClient client, int width, int height){
        super.init(client, width, height);

        String yesNo = "";
        if(showCoords){
            yesNo = "Yes";
        }else{
            yesNo = "No";
        }
        addButton(new ButtonWidget(this.width / 2 - 100, this.height / 6, 200, 20,new TranslatableText("options.vanplus.showcoords").append(": ").append(yesNo),(buttonWidget)->{
            showCoords = !showCoords;
            String ynCb;
            if(showCoords){
                ynCb = "Yes";
            }else{
                ynCb = "No";
            }
            buttonWidget.setMessage(new TranslatableText("options.vanplus.showcoords").append(": ").append(ynCb));
        }));
        addButton(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 144, 200, 20, ScreenTexts.DONE, (buttonWidget) -> {
            this.client.openScreen(this.parent);
        }));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        this.drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
     }
}