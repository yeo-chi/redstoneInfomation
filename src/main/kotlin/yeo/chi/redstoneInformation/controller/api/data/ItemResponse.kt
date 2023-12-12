package yeo.chi.redstoneInformation.controller.api.data

import org.bson.types.ObjectId
import yeo.chi.redstoneInformation.persistant.entity.Item
import yeo.chi.redstoneInformation.persistant.entity.ItemKind
import yeo.chi.redstoneInformation.persistant.entity.ItemTag

data class ItemResponse(
    val id: ObjectId,

    val kind: ItemKind,

    var type: List<ItemTag>,

    val name: String,

    val options: List<String>,

    val subOptions: List<String>,

    val condition: List<String>,
) {
    constructor(item: Item) : this(
        id = item.id,
        kind = item.kind,
        type = item.tags,
        name = item.name,
        options = item.options,
        subOptions = item.subOptions,
        condition = item.condition,
    )
}
