// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 
// Source File Name:   SourceFile

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            J_JsonNodeBuilder, J_JsonFieldBuilder

interface J_NodeContainer
{

    public abstract void addNode(J_JsonNodeBuilder j_jsonnodebuilder);

    public abstract void addField(J_JsonFieldBuilder j_jsonfieldbuilder);
}
