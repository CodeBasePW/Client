// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 
// Source File Name:   SourceFile

package net.minecraft.src;


public class ColorizerWater
{

    public ColorizerWater()
    {
    }

    public static void setWaterBiomeColorizer(int ai[])
    {
        waterBuffer = ai;
    }

    private static int waterBuffer[] = new int[0x10000];

}
