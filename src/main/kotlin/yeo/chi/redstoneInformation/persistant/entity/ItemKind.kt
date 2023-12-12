package yeo.chi.redstoneInformation.persistant.entity

enum class ItemKind(val description: String) {
    PUBLIC_ARMOR("공용갑옷"),

    CROWN("관"),

    EARRING("귀걸이"),

    WING("날개"),

    SICKLE("낫"),

    DAGGER("단도"),

    STAFF("마법지팡이"),

    WAND("마술봉"),

    CLOAK("망토"),

    MACE("철퇴"),

    NECKLACE("목걸이"),

    RING("반지"),

    NAIL("손톱"),

    SHIELD("방패"),

    BELT("벨트"),

    BOOTS("신발"),

    BROOMSTICK("빗자루"),

    CLAW("클로"),

    SLING("슬링"),

    BLADE("양손검"),

    TEETH("이빨"),

    GLOVES("장갑"),

    THROWER("투척기"),

    EXCLUSIVE_ARMOR("전용갑옷"),

    LANCE("창"),

    GUN("총"),

    WHIP("채찍"),

    BOOK("책"),

    BRACELET("팔찌"),

    FLUTE("피리"),

    SWORD("한손검"),

    HELMET("헬멧"),

    ARROW("화살"),

    BOW("활"),

    DOUBLE_SWORD("쌍검"),

    DARK_CORE("다크코어"),

    ALCHEMY_STONE("연금석"),

    ANCHOR("닻"),
    ;

    companion object {
        private val associateValue = ItemKind.values().associateBy { it.description }

        fun getItemKind(description: String) = associateValue[description] ?: throw NoSuchElementException()
    }
}
