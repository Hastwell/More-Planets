/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.objmodel;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.Vec3;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Face
{
    public Vertex[] vertices;
    public Vertex[] vertexNormals;
    public Vertex faceNormal;
    public TextureCoordinate[] textureCoordinates;

    @SideOnly(Side.CLIENT)
    public void addFaceForRender(Tessellator tessellator)
    {
        this.addFaceForRender(tessellator.getWorldRenderer(), 0.0005F);
    }

    @SideOnly(Side.CLIENT)
    public void addFaceForRender(WorldRenderer worldrenderer, float textureOffset)
    {
        if (this.faceNormal == null)
        {
            this.faceNormal = this.calculateFaceNormal();
        }

        float averageU = 0.0F;
        float averageV = 0.0F;

        if (this.textureCoordinates != null && this.textureCoordinates.length > 0)
        {
            for (int i = 0; i < this.textureCoordinates.length; ++i)
            {
                averageU += this.textureCoordinates[i].u;
                averageV += this.textureCoordinates[i].v;
            }
            averageU = averageU / this.textureCoordinates.length;
            averageV = averageV / this.textureCoordinates.length;
        }

        float offsetU, offsetV;

        for (int i = 0; i < this.vertices.length; ++i)
        {
            if (this.textureCoordinates != null && this.textureCoordinates.length > 0)
            {
                offsetU = textureOffset;
                offsetV = textureOffset;

                if (this.textureCoordinates[i].u > averageU)
                {
                    offsetU = -offsetU;
                }
                if (this.textureCoordinates[i].v > averageV)
                {
                    offsetV = -offsetV;
                }
                worldrenderer.func_181662_b(this.vertices[i].x, this.vertices[i].y, this.vertices[i].z).func_181673_a(this.textureCoordinates[i].u + offsetU, this.textureCoordinates[i].v + offsetV).func_181663_c(this.faceNormal.x, this.faceNormal.y, this.faceNormal.z).func_181675_d();
            }
            else
            {
                worldrenderer.func_181662_b(this.vertices[i].x, this.vertices[i].y, this.vertices[i].z).func_181663_c(this.faceNormal.x, this.faceNormal.y, this.faceNormal.z).func_181675_d();//TODO
            }
        }
    }

    public Vertex calculateFaceNormal()
    {
        Vec3 v1 = new Vec3(this.vertices[1].x - this.vertices[0].x, this.vertices[1].y - this.vertices[0].y, this.vertices[1].z - this.vertices[0].z);
        Vec3 v2 = new Vec3(this.vertices[2].x - this.vertices[0].x, this.vertices[2].y - this.vertices[0].y, this.vertices[2].z - this.vertices[0].z);
        Vec3 normalVector = v1.crossProduct(v2).normalize();
        return new Vertex((float) normalVector.xCoord, (float) normalVector.yCoord, (float) normalVector.zCoord);
    }
}