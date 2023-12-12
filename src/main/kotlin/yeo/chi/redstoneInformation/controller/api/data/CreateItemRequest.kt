package yeo.chi.redstoneInformation.controller.api.data

import yeo.chi.redstoneInformation.persistant.entity.Item
import yeo.chi.redstoneInformation.persistant.entity.ItemKind
import yeo.chi.redstoneInformation.persistant.entity.ItemTag

data class CreateItemRequest(
    val kind: ItemKind,

    var type: List<ItemTag>,

    val name: String,

    val options: List<String>,

    val subOptions: List<String>,

    val condition: List<String>,
) {
    fun toEntity(): Item {
        return Item(
            kind = kind,
            tags = type,
            name = name,
            options = options,
            subOptions = subOptions,
            condition = condition,
        )
    }
}
