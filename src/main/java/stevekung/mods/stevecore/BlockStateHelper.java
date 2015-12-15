/*******************************************************************************
 * Copyright 2015 SteveKunG - Steve's Core
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.stevecore;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.IStringSerializable;

public class BlockStateHelper
{
    /** Used for Custom TNT */
    public static PropertyBool EXPLODE = PropertyBool.create("explode");

    /** Used for Custom Basic Leaves */
    public static PropertyBool DECAYABLE = PropertyBool.create("decayable");
    public static PropertyBool CHECK_DECAY = PropertyBool.create("check_decay");

    /** Used for Custom Block Facing */
    public static PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    /** Used for Custom Wood Log */
    public static PropertyEnum AXIS = PropertyEnum.create("axis", EnumAxis.class);

    /** Used for Custom Cake */
    public static PropertyInteger BITES = PropertyInteger.create("bites", 0, 6);

    /** Used for Custom Farmland */
    public static PropertyInteger MOISTURE = PropertyInteger.create("moisture", 0, 1);

    /** Used for Custom Snow Layer */
    public static PropertyInteger LAYERS = PropertyInteger.create("layers", 1, 8);

    /** Used for Custom Colored Block */
    public static PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);

    public static enum EnumAxis implements IStringSerializable
    {
        X("x"),
        Y("y"),
        Z("z"),
        NONE("none");
        private String name;

        private EnumAxis(String name)
        {
            this.name = name;
        }

        @Override
        public String toString()
        {
            return this.name;
        }

        public static EnumAxis fromFacingAxis(Axis axis)
        {
            switch (SwitchAxis.AXIS_LOOKUP[axis.ordinal()])
            {
            case 1:
                return X;
            case 2:
                return Y;
            case 3:
                return Z;
            default:
                return NONE;
            }
        }

        @Override
        public String getName()
        {
            return this.name;
        }
    }

    public static class SwitchAxis
    {
        static int[] AXIS_LOOKUP = new int[Axis.values().length];

        static
        {
            try
            {
                AXIS_LOOKUP[Axis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError var3)
            {
            }

            try
            {
                AXIS_LOOKUP[Axis.Y.ordinal()] = 2;
            }
            catch (NoSuchFieldError var2)
            {
            }

            try
            {
                AXIS_LOOKUP[Axis.Z.ordinal()] = 3;
            }
            catch (NoSuchFieldError var1)
            {
            }
        }
    }

    public static class SwitchEnumAxis
    {
        public static int[] AXIS_LOOKUP = new int[EnumAxis.values().length];

        static
        {
            try
            {
                AXIS_LOOKUP[EnumAxis.X.ordinal()] = 1;
            }
            catch (NoSuchFieldError var3)
            {
            }

            try
            {
                AXIS_LOOKUP[EnumAxis.Z.ordinal()] = 2;
            }
            catch (NoSuchFieldError var2)
            {
            }

            try
            {
                AXIS_LOOKUP[EnumAxis.NONE.ordinal()] = 3;
            }
            catch (NoSuchFieldError var1)
            {
            }
        }
    }
}