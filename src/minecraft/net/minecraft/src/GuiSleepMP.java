// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 
// Source File Name:   SourceFile

package net.minecraft.src;

import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

// Referenced classes of package net.minecraft.src:
//            GuiChat, StringTranslate, GuiButton, EntityPlayerSP, 
//            EntityClientPlayerMP, Packet19EntityAction, NetClientHandler

public class GuiSleepMP extends GuiChat
{

    public GuiSleepMP()
    {
    }

    public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
        StringTranslate stringtranslate = StringTranslate.getInstance();
        controlList.add(new GuiButton(1, width / 2 - 100, height - 40, stringtranslate.translateKey("multiplayer.stopSleeping")));
    }

    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }

    protected void keyTyped(char c, int i)
    {
        if(i == 1)
        {
            wakeFromSleep();
        } else
        if(i == 28)
        {
            String s = message.trim();
            if(s.length() > 0)
            {
                mc.thePlayer.sendChatMessage(message.trim());
            }
            message = "";
        } else
        {
            super.keyTyped(c, i);
        }
    }

    public void drawScreen(int i, int j, float f)
    {
        super.drawScreen(i, j, f);
    }

    protected void actionPerformed(GuiButton guibutton)
    {
        if(guibutton.id == 1)
        {
            wakeFromSleep();
        } else
        {
            super.actionPerformed(guibutton);
        }
    }

    private void wakeFromSleep()
    {
        if(mc.thePlayer instanceof EntityClientPlayerMP)
        {
            NetClientHandler netclienthandler = ((EntityClientPlayerMP)mc.thePlayer).sendQueue;
            netclienthandler.addToSendQueue(new Packet19EntityAction(mc.thePlayer, 3));
        }
    }
}