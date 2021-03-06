package vazkii.craftingcreation.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import vazkii.craftingcreation.block.TileEntityVault;

public class ContainerVault extends Container {
	
	TileEntityVault tile;
	
	public ContainerVault(IInventory playerInv, TileEntityVault vaultInv) {
		this.tile = vaultInv;
        int numRows = vaultInv.getSizeInventory() / 9;
        int i = (numRows - 4) * 18;

        for (int j = 0; j < numRows; ++j)
            for (int k = 0; k < 9; ++k)
                addSlotToContainer(new Slot(vaultInv, k + j * 9, 8 + k * 18, 18 + j * 18));

        for (int j = 0; j < 3; ++j)
            for (int k = 0; k < 9; ++k)
                addSlotToContainer(new Slot(playerInv, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));

        for (int j = 0; j < 9; ++j)
            addSlotToContainer(new Slot(playerInv, j, 8 + j * 18, 161 + i));	
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		return null;
    }
}
