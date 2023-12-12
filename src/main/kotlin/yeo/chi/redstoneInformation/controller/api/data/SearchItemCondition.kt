package yeo.chi.redstoneInformation.controller.api.data

import yeo.chi.redstoneInformation.persistant.entity.ItemKind
import yeo.chi.redstoneInformation.persistant.entity.ItemTag

data class SearchItemCondition(
    val kind: ItemKind? = null,

    val tags: List<ItemTag> = listOf(),

    val name: String? = null,

    val option: String? = null,
)
