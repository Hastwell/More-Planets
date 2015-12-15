/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.world.gen.village;

public class StructureVenusVillagePieceWeight
{
    public Class<? extends ComponentVenusVillage> villagePieceClass;
    public int villagePieceWeight;
    public int villagePiecesSpawned;
    public int villagePiecesLimit;

    public StructureVenusVillagePieceWeight(Class<? extends ComponentVenusVillage> component, int weight, int limit)
    {
        this.villagePieceClass = component;
        this.villagePieceWeight = weight;
        this.villagePiecesLimit = (int) (limit / 1.5D);
    }

    public boolean canSpawnMoreVillagePiecesOfType()
    {
        return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
    }

    public boolean canSpawnMoreVillagePieces()
    {
        return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
    }
}