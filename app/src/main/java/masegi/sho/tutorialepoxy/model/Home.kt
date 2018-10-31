package masegi.sho.tutorialepoxy.model

data class Home(
    var name: String,
    var owner: String,
    var starCount: Int = 0,
    var price: Int = 0
)