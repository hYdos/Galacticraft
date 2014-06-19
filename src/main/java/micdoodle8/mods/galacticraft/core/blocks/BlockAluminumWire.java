package micdoodle8.mods.galacticraft.core.blocks;

import java.util.List;

import micdoodle8.mods.galacticraft.api.transmission.NetworkType;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.tile.TileEntityAluminumWire;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAluminumWire extends BlockTransmitter implements ITileEntityProvider
{
	public static final String[] names = { "aluminumWire", "aluminumWireHeavy" };
	private static IIcon[] blockIcons;

	public BlockAluminumWire(String assetName)
	{
		super(Material.cloth);
		this.setStepSound(Block.soundTypeCloth);
		this.setResistance(0.2F);
		this.setBlockBounds(0.4F, 0.4F, 0.4F, 0.6F, 0.6F, 0.6F);
		this.minVector = new Vector3(0.4, 0.4, 0.4);
		this.maxVector = new Vector3(0.6, 0.6, 0.6);
		this.setHardness(0.075F);
		this.setBlockName(assetName);
	}

	@Override
	public CreativeTabs getCreativeTabToDisplayOn()
	{
		return GalacticraftCore.galacticraftBlocksTab;
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		BlockAluminumWire.blockIcons = new IIcon[BlockAluminumWire.names.length];

		for (int i = 0; i < BlockAluminumWire.names.length; i++)
		{
			BlockAluminumWire.blockIcons[i] = par1IconRegister.registerIcon(GalacticraftCore.ASSET_PREFIX + BlockAluminumWire.names[i]);
		}
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		switch (meta)
		{
		case 0:
			return BlockAluminumWire.blockIcons[0];
		case 1:
			return BlockAluminumWire.blockIcons[1];
		default:
			return BlockAluminumWire.blockIcons[0];
		}
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
		switch (metadata)
		{
		case 0:
			return new TileEntityAluminumWire();
		case 1:
			return new TileEntityAluminumWire(0.025F, 400.0F);
		default:
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
	}

	@Override
	public NetworkType getNetworkType()
	{
		return NetworkType.POWER;
	}
}
