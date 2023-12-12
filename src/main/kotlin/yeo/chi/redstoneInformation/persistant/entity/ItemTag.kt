package yeo.chi.redstoneInformation.persistant.entity

enum class ItemTag(val description: String) {
    BLACK_FIRE("블랙파이어"),

    CORRUPTION("커럽"),

    DX("DX"),

    ETERNAL("이터널"),

    SECRET("비밀던전"),

    PVP("PVP"),

    ULTIMATE("얼티메이트"),

    YATIKANU("야티카누"),
    ;

    companion object {
        private val associateValue = ItemTag.values().associateBy { it.description }

        fun getItemTag(description: String) = associateValue[description] ?: throw NoSuchElementException()
    }
}
