import org.w3c.dom.HTMLDivElement
import kotlin.browser.document
import kotlin.random.Random

fun generate() {
    val lastNamesOriginal = listOf(
            "Barnett",
            "Bigbooté",
            "Camp",
            "Careful Walker",
            "Chief Crier",
            "Cooper",
            "Coyote",
            "Edwards",
            "Emdall",
            "Fat Eating",
            "Fish",
            "Fledgling",
            "Gant",
            "Gomez",
            "Grim",
            "Guardian",
            "Icicle Boy",
            "Jones",
            "Joseph",
            "Kim Chi",
            "Lee",
            "Littlejohn",
            "Many Jars",
            "Milton",
            "Mud Head",
            "Nephew",
            "Nolan",
            "O'Connor",
            "Omar",
            "Parker",
            "Parrot",
            "Rajeesh",
            "Ready to Fly",
            "Repeat Dance",
            "Roberts",
            "Scott",
            "Shaw",
            "Smallberries",
            "Starbird",
            "Take Cover",
            "Thorny Stick",
            "Turk",
            "Two Horns",
            "Web",
            "Whorfin",
            "Wood",
            "Wright",
            "Ya Ya",
            "Valuk"
    )

    val adjectivesEither = listOf(
            "Careful",
            "Chief",
            "Fat",
            "Icicle",
            "Little",
            "Mud",
            "Repeat",
            "Small",
            "Thorny"
    )
    val adjectivesPlural = listOf(
            "Many",
            "Two"
    )

    val lastNames = listOf(
            "Barnett",
            "Bigbooté",
            "Cooper",
            "Edwards",
            "Emdall",
            "Gant",
            "Gomez",
            "Grim",
            "Jones",
            "Joseph",
            "Lee",
            "Milton",
            "Nolan",
            "O'Connor",
            "Omar",
            "Parker",
            "Rajeesh",
            "Ready to Fly",
            "Roberts",
            "Scott",
            "Shaw",
            "Take Cover",
            "Turk",
            "Valuk",
            "Whorfin",
            "Wright",
            "Web",
            "Whorfin",
            "Ya Ya"
    )

    val nounsSingular = listOf(
            "Bird",
            "Boy",
            "Camp",
            "Crier",
            "Coyote",
            "Dance",
            "Eating",
            "Fish",
            "Fledgling",
            "Head",
            "John",
            "Kim Chi",
            "Nephew",
            "Parrot",
            "Stick",
            "Walker",
            "Wood"
    )
    val nounsPlural = listOf(
            "Berries",
            "Horns",
            "Jars"
    )

    val adjectiveProbability = 2.0 / 5.0 // Should be 11/49, but more fun this way.
    val oneWordProbability = 2.0 / 11.0

    val lastName = if (Random.nextDouble() <= adjectiveProbability) {
        val adjective = (adjectivesEither + adjectivesPlural).random()
        val plural = adjective in adjectivesPlural
        val noun = if (plural) nounsPlural.random() else nounsSingular.random()

        if (Random.nextDouble() <= oneWordProbability) {
            "$adjective${noun.toLowerCase()}"
        } else {
            "$adjective $noun"
        }
    } else {
        lastNames.random()
    }

    val perfect = lastNamesOriginal.contains(lastName)

    document.getElementById("name")!!.innerHTML = "John $lastName"
    (document.getElementById("new") as HTMLDivElement).style.display = if (perfect) "none" else "block"
    (document.getElementById("tommy") as HTMLDivElement).style.display = if (perfect) "block" else "none"
}
