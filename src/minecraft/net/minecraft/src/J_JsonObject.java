// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 
// Source File Name:   SourceFile

package net.minecraft.src;

import java.util.*;

// Referenced classes of package net.minecraft.src:
//            J_JsonRootNode, EnumJsonNodeType

final class J_JsonObject extends J_JsonRootNode
{

    J_JsonObject(Map map)
    {
        fields = new HashMap(map);
    }

    public Map getFields()
    {
        return new HashMap(fields);
    }

    public EnumJsonNodeType getType()
    {
        return EnumJsonNodeType.OBJECT;
    }

    public String getText()
    {
        throw new IllegalStateException("Attempt to get text on a JsonNode without text.");
    }

    public List getElements()
    {
        throw new IllegalStateException("Attempt to get elements on a JsonNode without elements.");
    }

    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(obj == null || getClass() != obj.getClass())
        {
            return false;
        } else
        {
            J_JsonObject j_jsonobject = (J_JsonObject)obj;
            return fields.equals(j_jsonobject.fields);
        }
    }

    public int hashCode()
    {
        return fields.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("JsonObject fields:[").append(fields).append("]").toString();
    }

    private final Map fields;
}
