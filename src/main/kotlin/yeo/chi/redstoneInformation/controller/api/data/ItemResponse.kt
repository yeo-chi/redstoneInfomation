package yeo.chi.redstoneInformation.controller.api.data

import org.bson.types.ObjectId
import yeo.chi.redstoneInformation.persistant.entity.Item
import yeo.chi.redstoneInformation.persistant.entity.ItemKind
import yeo.chi.redstoneInformation.persistant.entity.ItemTag

data class ItemResponse(
    val id: ObjectId,

    val kind: ItemKind,

    var type: LinkedHashSet<ItemTag>,

    val name: String,

    val options: LinkedHashSet<String>,

    val subOptions: LinkedHashSet<String>,

    val condition: LinkedHashSet<String>,
) {
    constructor(item: Item) : this(
        id = item.id,
        kind = item.kind,
        type = item.type,
        name = item.name,
        options = item.options,
        subOptions = item.subOptions,
        condition = item.condition,
    )
}
