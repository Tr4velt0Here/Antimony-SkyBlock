package com.greencat.common.ui.transparent;

import com.greencat.Antimony;
import com.greencat.common.config.getConfigByFunctionName;
import com.greencat.common.register.AntimonyRegister;
import com.greencat.type.AntimonyFunction;
import com.greencat.utils.FontManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class FunctionList {
    Minecraft mc = Minecraft.getMinecraft();

    public void draw() {
        ScaledResolution scaledResolution = new ScaledResolution(mc);
        FontManager.GothamRoundedFont.drawSmoothString("",0,0,0xFFFFFF);
        int height = (Integer) getConfigByFunctionName.get("HUD","FunctionListHeight");
        ResourceLocation resourceLocation = new ResourceLocation(Antimony.MODID, "hud2.png");
        for (AntimonyFunction function : AntimonyRegister.FunctionList) {
            if(function.getStatus()) {
                Minecraft.getMinecraft().renderEngine.bindTexture(resourceLocation);
                Gui.drawModalRectWithCustomSizedTexture((int) (scaledResolution.getScaledWidth() - FontManager.GothamRoundedFont.getStringWidth(function.getName()) - 6),height,0,0, (int) FontManager.GothamRoundedFont.getStringWidth(function.getName()) + 6,14, (float) FontManager.GothamRoundedFont.getStringWidth(function.getName()) + 6,28);
                FontManager.GothamRoundedFont.drawSmoothString(function.getName(),scaledResolution.getScaledWidth() - FontManager.GothamRoundedFont.getStringWidth(function.getName()) - 3,height + 5,0xFFFFFF);
                height = height + 14;
            }
        }
    }
}
