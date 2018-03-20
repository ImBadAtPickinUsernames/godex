package com.imbadatpickindomains.godex

/**
 * Created by domin on 19.03.2018.
 */

data class Pokemon(
		val dex: Int,
		val name: String,
		val animationTime: List<Double>,
		val height: Double,
		val modelHeight: Double,
		val kmBuddyDistance: Int,
		val weight: Double,
		val modelScale: Double,
		val id: String,
		val maxCP: Int,
		val cinematicMoves: List<CinematicMove>,
		val quickMoves: List<QuickMove>,
		val family: Family,
		val stats: Stats,
		val types: List<Type>,
		val encounter: Encounter,
		val camera: Camera,
		val evolution: Evolution
) {
	data class Evolution(
			val futureBranches: List<FutureBranche>
	) {
		data class FutureBranche(
				val name: String,
				val id: String,
				val futureBranches: List<FutureBranche>,
				val costToEvolve: CostToEvolve
		) {
			data class CostToEvolve(
					val candyCost: Int
			)
			data class FutureBranche(
					val name: String,
					val id: String,
					val costToEvolve: CostToEvolve
			) {
				data class CostToEvolve(
						val candyCost: Int
				)
			}
		}
	}

	data class QuickMove(
			val name: String,
			val id: String
	)

	data class Family(
			val id: String,
			val name: String
	)

	data class Encounter(
			val attackProbability: Double,
			val attackTimer: Int,
			val baseFleeRate: Double,
			val baseCaptureRate: Double,
			val cameraDistance: Double,
			val collisionRadius: Double,
			val dodgeDistance: Double,
			val dodgeProbability: Double,
			val jumpTime: Double,
			val maxPokemonActionFrequency: Double,
			val minPokemonActionFrequency: Double,
			val movementType: MovementType,
			val gender: Gender
	) {
		data class MovementType(
				val name: String,
				val id: String
		)
		data class Gender(
				val malePercent: Double,
				val femalePercent: Double
		)
	}

	data class Camera(
			val cylinderRadius: Double,
			val diskRadius: Double,
			val shoulderModeScale: Double
	)

	data class CinematicMove(
			val name: String,
			val id: String
	)

	data class Stats(
			val baseAttack: Int,
			val baseDefense: Int,
			val baseStamina: Int
	)

	data class Type(
			val id: String,
			val name: String
	)
}