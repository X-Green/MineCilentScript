package dev.eeasee.minecraft_client_script.mixin;

import dev.eeasee.minecraft_client_script.gui.script_manager.ScriptManagerScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class MixinTitleScreen extends Screen {

    public MixinTitleScreen(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "initWidgetsNormal(II)V")
    private void drawMenuButton(CallbackInfo ci) {
        this.addButton(ScriptManagerScreen.ScriptManagerButtonWidget.newScriptManagerButtonWidget(this));
    }
}
