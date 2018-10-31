package masegi.sho.tutorialepoxy.model

data class City(
    var name: String,
    var description: String,
    var popularHomes: List<Home> = listOf(),
    var northEnd: List<Home> = listOf()
)