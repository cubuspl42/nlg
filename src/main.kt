/**
 * Created by kuba on 19.12.16.
 */

import GrammaticalCase.*

val lexicon = mapOf(
        "kot" to Lexeme(singular = mapOf(
                NOMINATIVE to "kot", // mianownik; kto? co?
                GENITIVE to "kota", // dopełniacz; kogo? czego? (nie ma)
                DATIVE to "kotu", // celownik; komu? czemu? (się przyglądam)
                ACCUSATIVE to "kota", // biernik; kogo? co? (widzę)
                INSTRUMENTAL to "kotem", // narzędnik; (z) kim? (z) czym? (idę)
                LOCATIVE to "kocie", // miejscownik; o kim? o czym? (mówię)
                VOCATIVE to "kocie" // wołacz; zwrot do kogoś lub czegoś
        ), plural = mapOf(
                NOMINATIVE to "koty", // mianownik; kto? co?
                GENITIVE to "kotów", // dopełniacz; kogo? czego? (nie ma)
                DATIVE to "kotom", // celownik; komu? czemu? (się przyglądam)
                ACCUSATIVE to "koty", // biernik; kogo? co? (widzę)
                INSTRUMENTAL to "kotami", // narzędnik; (z) kim? (z) czym? (idę)
                LOCATIVE to "kotach", // miejscownik; o kim? o czym? (mówię)
                VOCATIVE to "koty" // wołacz; zwrot do kogoś lub czegoś
        ))
)

fun inflectForNumeral(word: String, numeralValue: Int): String {
    val lx = lexicon[word]!!
    val singularNominative = lx.singular[NOMINATIVE]!!
    val pluralNominative = lx.plural[NOMINATIVE]!!
    val pluralGenitive = lx.plural[GENITIVE]!!
    return when {
        numeralValue == 1 -> singularNominative
        numeralValue % 100 in 12..14 -> pluralGenitive
        numeralValue % 10 in 2..4 -> pluralNominative
        else -> pluralGenitive
    }
}

fun main(args: Array<String>) {
    for(i in 0..1000) {
        println("$i " + inflectForNumeral("kot", i))
    }
}
