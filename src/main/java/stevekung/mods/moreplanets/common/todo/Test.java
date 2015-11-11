//import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.init.Blocks;
//import net.minecraft.util.BlockPos;
//import net.minecraft.util.EnumParticleTypes;
//import net.minecraft.util.MathHelper;
//import net.minecraft.world.World;
//import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//
//	@SubscribeEvent
//	public void onEntityLivingUpdate(LivingUpdateEvent event)
//	{
//		EntityLivingBase entity = event.entityLiving;
//		World world = entity.worldObj;
//
//		if (world.getBlockState(new BlockPos((int) Math.floor(entity.posX), (int) Math.floor(entity.posY), (int) Math.floor(entity.posZ)).down()).getBlock() == Blocks.grass)
//		{
//			if ((entity.motionX > 0 || entity.motionX < 0) || (entity.motionZ > 0 || entity.motionZ < 0))
//			{
//				if (event.entityLiving.isCollidedVertically)
//				{
//					if (world.rand.nextInt(2) == 0)
//					{
//						if (world.rand.nextInt(2) == 0)
//						{
//							float f = MathHelper.sqrt_double(entity.motionX * entity.motionX * 0.20000000298023224D + entity.motionY * entity.motionY + entity.motionZ * entity.motionZ * 0.20000000298023224D) * 0.4F;
//
//							if (f > 1.0F)
//							{
//								f = 1.0F;
//							}
//							entity.playSound("game.neutral.swim", f, 1.0F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.4F);
//						}
//						world.spawnParticle(EnumParticleTypes.WATER_SPLASH, entity.posX + ((double)world.rand.nextFloat() - 0.5D) * (double)entity.width, entity.getEntityBoundingBox().minY + 0.1D, entity.posZ + ((double)world.rand.nextFloat() - 0.5D) * (double)entity.width, -entity.motionX, 0.6D, -entity.motionZ);
//					}
//				}
//			}
//		}
//	}