package ru.spbau.mit.belyaev

/**
 * @author belaevstanislav
 */
data class Params(val hp: Double = .0,
                  val maxHp: Double = .0,
                  val hpRegen: Double = .0,
                  val armor: Double = .0,
                  val attack: Double = .0) {
    operator fun plus(b: Params) =
            Params(hp = hp + b.hp,
                    maxHp = maxHp + b.maxHp,
                    hpRegen = hpRegen + b.hpRegen,
                    armor = armor + b.armor,
                    attack = attack + b.attack)
}