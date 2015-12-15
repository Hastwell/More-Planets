/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.blocks.other;

import java.util.List;
import java.util.Random;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.moons.io.tileentities.TileEntityIoDungeonSpawner;
import stevekung.mods.moreplanets.moons.koentus.tileentities.TileEntityKoentusDungeonSpawner;
import stevekung.mods.moreplanets.planets.diona.tileentities.TileEntityDionaDungeonSpawner;
import stevekung.mods.moreplanets.planets.fronos.tileentities.TileEntityFronosDungeonSpawner;
import stevekung.mods.moreplanets.planets.kapteynb.tileentities.TileEntityKapteynBDungeonSpawner;
import stevekung.mods.moreplanets.planets.mercury.tileentities.TileEntityMercuryDungeonSpawner;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityNibiruDungeonSpawner;
import stevekung.mods.moreplanets.planets.pluto.tileentities.TileEntityPlutoDungeonSpawner;
import stevekung.mods.moreplanets.planets.polongnius.tileentities.TileEntityPolongniusDungeonSpawner;
import stevekung.mods.moreplanets.planets.siriusb.tileentities.TileEntitySiriusBDungeonSpawner;
import stevekung.mods.moreplanets.planets.venus.tileentities.TileEntityVenusDungeonSpawner;

public class BlockDungeonSpawner extends BlockBaseMP implements ITileEntityProvider
{
    public static PropertyEnum PLANET = PropertyEnum.create("planet", DungeonType.class);

    public BlockDungeonSpawner(String name)
    {
        super(Material.barrier);
        this.setBlockUnbreakable();
        this.setResistance(6000001.0F);
        this.translucent = true;
        this.setDefaultState(this.getDefaultState().withProperty(PLANET, DungeonType.diona));
        this.setUnlocalizedName(name);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state)
    {
        return null;
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, BlockPos pos, Vec3 start, Vec3 end)
    {
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int i = 0; i < 15; ++i)
        {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public CreativeTabs getCreativeTabToDisplayOn()
    {
        return null;
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean isFullCube()
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getAmbientOcclusionLightValue()
    {
        return 1.0F;
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition moving, World world, BlockPos pos, EntityPlayer player)
    {
        return null;
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        switch (meta)
        {
        case 0:
            return new TileEntityDionaDungeonSpawner();
        case 1:
            return new TileEntityPolongniusDungeonSpawner();
        case 2:
            return new TileEntityNibiruDungeonSpawner();
        case 3:
            return new TileEntityKoentusDungeonSpawner();
        case 4:
            return new TileEntityFronosDungeonSpawner();
        case 5:
            return new TileEntityKapteynBDungeonSpawner();
        case 6:
            return new TileEntitySiriusBDungeonSpawner();
        case 7:
            return new TileEntityMercuryDungeonSpawner();
        case 8:
            return new TileEntityVenusDungeonSpawner();
        case 9:
            return new TileEntityIoDungeonSpawner();
        case 10:
            return new TileEntityPlutoDungeonSpawner();
        default:
            return null;
        }
    }

    @Override
    public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player)
    {
        return false;
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random rand)
    {
        return 0;
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { PLANET });
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(PLANET, DungeonType.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((DungeonType)state.getValue(PLANET)).ordinal();
    }

    public static enum DungeonType implements IStringSerializable
    {
        diona,
        polongnius,
        nibiru,
        koentus,
        fronos,
        kapteyn_b,
        sirius_b,
        mercury,
        venus,
        io,
        pluto;

        @Override
        public String toString()
        {
            return this.getName();
        }

        @Override
        public String getName()
        {
            return this.name();
        }
    }
}