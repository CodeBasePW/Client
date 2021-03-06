// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 
// Source File Name:   SourceFile

package net.minecraft.src;

import java.io.*;

// Referenced classes of package net.minecraft.src:
//            J_ThingWithPosition

final class J_PositionTrackingPushbackReader
    implements J_ThingWithPosition
{

    public J_PositionTrackingPushbackReader(Reader reader)
    {
        characterCount = 0;
        lineCount = 1;
        lastCharacterWasCarriageReturn = false;
        pushbackReader = new PushbackReader(reader);
    }

    public void unread(char c)
        throws IOException
    {
        characterCount--;
        if(characterCount < 0)
        {
            characterCount = 0;
        }
        pushbackReader.unread(c);
    }

    public void uncount(char ac[])
    {
        characterCount = characterCount - ac.length;
        if(characterCount < 0)
        {
            characterCount = 0;
        }
    }

    public int read()
        throws IOException
    {
        int i = pushbackReader.read();
        updateCharacterAndLineCounts(i);
        return i;
    }

    public int read(char ac[])
        throws IOException
    {
        int i = pushbackReader.read(ac);
        char ac1[] = ac;
        int j = ac1.length;
        for(int k = 0; k < j; k++)
        {
            char c = ac1[k];
            updateCharacterAndLineCounts(c);
        }

        return i;
    }

    private void updateCharacterAndLineCounts(int i)
    {
        if(13 == i)
        {
            characterCount = 0;
            lineCount++;
            lastCharacterWasCarriageReturn = true;
        } else
        {
            if(10 == i && !lastCharacterWasCarriageReturn)
            {
                characterCount = 0;
                lineCount++;
            } else
            {
                characterCount++;
            }
            lastCharacterWasCarriageReturn = false;
        }
    }

    public int getColumn()
    {
        return characterCount;
    }

    public int getRow()
    {
        return lineCount;
    }

    private final PushbackReader pushbackReader;
    private int characterCount;
    private int lineCount;
    private boolean lastCharacterWasCarriageReturn;
}
