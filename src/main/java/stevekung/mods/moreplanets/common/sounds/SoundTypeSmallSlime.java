/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.sounds;

import net.minecraft.block.Block.SoundType;

public class SoundTypeSmallSlime extends SoundType
{
    public SoundTypeSmallSlime()
    {
        super("slime", 1.0F, 1.0F);
    }

    @Override
    public String getBreakSound()
    {
        return "mob.slime.small";
    }

    @Override
    public String getStepSound()
    {
        return "mob.slime.small";
    }
}