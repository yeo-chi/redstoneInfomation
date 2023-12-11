package yeo.chi.redstoneInformation.controller.api.data

import yeo.chi.redstoneInformation.persistant.entity.Item
import yeo.chi.redstoneInformation.persistant.entity.ItemKind
import yeo.chi.redstoneInformation.persistant.entity.ItemTag

data class CreateItemRequest(
    val kind: ItemKind,

    var type: LinkedHashSet<ItemTag>,

    val name: String,

    val options: LinkedHashSet<String>,

    val subOptions: LinkedHashSet<String>,

    val condition: LinkedHashSet<String>,
) {
    fun toEntity(): Item {
        return Item(
            kind = kind,
            type = type,
            name = name,
            options = options,
            subOptions = subOptions,
            condition = condition,
        )
    }
}
