package extrabiomes.biomes;

import java.util.Random;

import net.minecraft.src.BiomeDecorator;
import net.minecraft.src.WorldGenShrub;
import net.minecraft.src.WorldGenerator;
import extrabiomes.terrain.CustomBiomeDecorator;
import extrabiomes.terrain.WorldGenNoOp;

public class BiomeShrubland extends ExtrabiomeGenBase {

	public BiomeShrubland(int id) {
		super(id);

		setColor(0x51B57D);
		setBiomeName("Shrubland");
		temperature = 0.4F;
		rainfall = 0.6F;
		minHeight = 0.1F;
		maxHeight = 0.3F;
	}

	@Override
	protected BiomeDecorator createBiomeDecorator() {
		return new CustomBiomeDecorator.Builder(this).treesPerChunk(0)
				.flowersPerChunk(3).grassPerChunk(1).build();
	}

	@Override
	public WorldGenerator getRandomWorldGenForTrees(Random rand) {
		return rand.nextInt(3) <= 1 ? new WorldGenShrub(3, rand.nextInt(3))
				: new WorldGenNoOp();
	}

}
