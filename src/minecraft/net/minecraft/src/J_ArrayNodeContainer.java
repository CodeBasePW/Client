// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 
// Source File Name:   SourceFile

package net.minecraft.src;


// Referenced classes of package net.minecraft.src:
//            J_NodeContainer, J_JsonArrayNodeBuilder, J_JsonListenerToJdomAdapter, J_JsonNodeBuilder, 
//            J_JsonFieldBuilder

class J_ArrayNodeContainer
    implements J_NodeContainer
{

    J_ArrayNodeContainer(J_JsonListenerToJdomAdapter j_jsonlistenertojdomadapter, J_JsonArrayNodeBuilder j_jsonarraynodebuilder)
    {
//        super();
        listenerToJdomAdapter = j_jsonlistenertojdomadapter;
        nodeBuilder = j_jsonarraynodebuilder;
    }

    public void addNode(J_JsonNodeBuilder j_jsonnodebuilder)
    {
        nodeBuilder.addField(j_jsonnodebuilder);
    }

    public void addField(J_JsonFieldBuilder j_jsonfieldbuilder)
    {
        throw new RuntimeException("Coding failure in Argo:  Attempt to add a field to an array.");
    }

    final J_JsonArrayNodeBuilder nodeBuilder; /* synthetic field */
    final J_JsonListenerToJdomAdapter listenerToJdomAdapter; /* synthetic field */
}
