package plus.vanilla.settings;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

public class VanPlusOptions extends Screen {

    private final Screen parent;

    public VanPlusOptions(Screen parentScreen) {
        super(new TranslatableText("menu.vanplus.options"));
        this.parent = parentScreen;
    }
    
    @Override
    public void init(MinecraftClient client, int width, int height){
        this.client = client;
        this.width = width;
        this.height = height;
        this.textRenderer = client.textRenderer;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        this.drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 15, 16777215);
        super.render(matrices, mouseX, mouseY, delta);
     }
}