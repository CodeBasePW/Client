// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 
// Source File Name:   SourceFile

package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

// Referenced classes of package net.minecraft.src:
//            Block, Material, World, PistonBlockTextures, 
//            BlockPistonBase, IBlockAccess, AxisAlignedBB

public class BlockPistonExtension extends Block
{

    public BlockPistonExtension(int i, int j)
    {
        super(i, j, Material.piston);
        headTexture = -1;
        setStepSound(soundStoneFootstep);
        setHardness(0.5F);
    }

    public void setHeadTexture(int i)
    {
        headTexture = i;
    }

    public void clearHeadTexture()
    {
        headTexture = -1;
    }

    public void onBlockRemoval(World world, int i, int j, int k)
    {
        super.onBlockRemoval(world, i, j, k);
        int l = world.getBlockMetadata(i, j, k);
        int j1 = PistonBlockTextures.faceToSide[getDirectionMeta(l)];
        i += PistonBlockTextures.offsetsXForSide[j1];
        j += PistonBlockTextures.offsetsYForSide[j1];
        k += PistonBlockTextures.offsetsZForSide[j1];
        int k1 = world.getBlockId(i, j, k);
        if(k1 == Block.pistonBase.blockID || k1 == Block.pistonStickyBase.blockID)
        {
            int i1 = world.getBlockMetadata(i, j, k);
            if(BlockPistonBase.isPowered(i1))
            {
                Block.blocksList[k1].dropBlockAsItem(world, i, j, k, i1);
                world.setBlockWithNotify(i, j, k, 0);
            }
        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j)
    {
        int k = getDirectionMeta(j);
        if(i == k)
        {
            if(headTexture >= 0)
            {
                return headTexture;
            }
            if((j & 8) != 0)
            {
                return blockIndexInTexture - 1;
            } else
            {
                return blockIndexInTexture;
            }
        }
        return i != PistonBlockTextures.faceToSide[k] ? 108 : 107;
    }

    public int getRenderType()
    {
        return 17;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        return false;
    }

    public boolean canPlaceBlockOnSide(World world, int i, int j, int k, int l)
    {
        return false;
    }

    public int quantityDropped(Random random)
    {
        return 0;
    }

    public void getCollidingBoundingBoxes(World world, int i, int j, int k, AxisAlignedBB axisalignedbb, ArrayList arraylist)
    {
        int l = world.getBlockMetadata(i, j, k);
        switch(getDirectionMeta(l))
        {
        case 0: // '\0'
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.375F, 0.25F, 0.375F, 0.625F, 1.0F, 0.625F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 1: // '\001'
            setBlockBounds(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 0.75F, 0.625F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 2: // '\002'
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.25F, 0.375F, 0.25F, 0.75F, 0.625F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 3: // '\003'
            setBlockBounds(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.25F, 0.375F, 0.0F, 0.75F, 0.625F, 0.75F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 4: // '\004'
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.375F, 0.25F, 0.25F, 0.625F, 0.75F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            break;

        case 5: // '\005'
            setBlockBounds(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            setBlockBounds(0.0F, 0.375F, 0.25F, 0.75F, 0.625F, 0.75F);
            super.getCollidingBoundingBoxes(world, i, j, k, axisalignedbb, arraylist);
            break;
        }
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockMetadata(i, j, k);
        switch(getDirectionMeta(l))
        {
        case 0: // '\0'
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
            break;

        case 1: // '\001'
            setBlockBounds(0.0F, 0.75F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;

        case 2: // '\002'
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.25F);
            break;

        case 3: // '\003'
            setBlockBounds(0.0F, 0.0F, 0.75F, 1.0F, 1.0F, 1.0F);
            break;

        case 4: // '\004'
            setBlockBounds(0.0F, 0.0F, 0.0F, 0.25F, 1.0F, 1.0F);
            break;

        case 5: // '\005'
            setBlockBounds(0.75F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            break;
        }
    }

    public void onNeighborBlockChange(World world, int i, int j, int k, int l)
    {
        int i1 = getDirectionMeta(world.getBlockMetadata(i, j, k));
        int j1 = world.getBlockId(i - PistonBlockTextures.offsetsXForSide[i1], j - PistonBlockTextures.offsetsYForSide[i1], k - PistonBlockTextures.offsetsZForSide[i1]);
        if(j1 != Block.pistonBase.blockID && j1 != Block.pistonStickyBase.blockID)
        {
            world.setBlockWithNotify(i, j, k, 0);
        } else
        {
            Block.blocksList[j1].onNeighborBlockChange(world, i - PistonBlockTextures.offsetsXForSide[i1], j - PistonBlockTextures.offsetsYForSide[i1], k - PistonBlockTextures.offsetsZForSide[i1], l);
        }
    }

    public static int getDirectionMeta(int i)
    {
        return i & 7;
    }

    private int headTexture;
}
