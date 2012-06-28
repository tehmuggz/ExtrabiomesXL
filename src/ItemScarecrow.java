package net.minecraft.src;

import net.minecraft.src.forge.*;

public class ItemScarecrow extends Item implements ITextureProvider
{
    public ItemScarecrow(int par1)
    {
        super(par1);
    }
    
    public boolean func_46058_c()
    {
        return true;
    }

    public int func_46057_a(int par1, int par2)
    {
        return par2 > 0 ? super.func_46057_a(par1, par2) + 16 : super.func_46057_a(par1, par2);
    }
    
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7)
    {
        if (par3World.isRemote)
        {
            return true;
        }
        else
        {
            int var8 = par3World.getBlockId(par4, par5, par6);
            par4 += Facing.offsetsXForSide[par7];
            par5 += Facing.offsetsYForSide[par7];
            par6 += Facing.offsetsZForSide[par7];
            double var9 = 0.0D;

            if (par7 == 1 && var8 == Block.fence.blockID || var8 == Block.netherFence.blockID)
            {
                var9 = 0.5D;
            }

            if (func_48440_a(par3World, par1ItemStack.getItemDamage(), (double)par4 + 0.5D, (double)par5 + var9, (double)par6 + 0.5D) && !par2EntityPlayer.capabilities.isCreativeMode)
            {
                --par1ItemStack.stackSize;
            }

            return true;
        }
    }

    public static boolean func_48440_a(World par0World, int par1, double par2, double par4, double par6)
    {
        {
            Entity var8 = EntityList.createEntityByName("scarecrow", par0World);

            if (var8 != null)
            {
                var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
                par0World.spawnEntityInWorld(var8);
            }

            return var8 != null;
        }
    }
    
    public String getTextureFile()
    {
            return "/ExtraBiomesXL/extrabiomes.png";
    }
}