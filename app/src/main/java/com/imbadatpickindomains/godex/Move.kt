package com.imbadatpickindomains.godex

/**
 * Created by domin on 20.03.2018.
 */

data class Move(
		val accuracyChange: Int,
		val animationId: Int,
		val power: Int,
		val criticalChance: Double,
		val staminaLossScalar: Double,
		val trainerLevelMin: Int,
		val trainerLevelMax: Int,
		val vfxName: String,
		val durationMs: Int,
		val damageWindowStartMs: Int,
		val damageWindowEndMs: Int,
		val energyDelta: Int,
		val id: String,
		val pokemonType: PokemonType,
		val name: String,
		val internalId: Int
) {
	data class PokemonType(
			val id: String,
			val name: String
	)
}