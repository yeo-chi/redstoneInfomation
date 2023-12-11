package yeo.chi.redstoneInformation.persistant.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "items")
class Item(
    @Id
    val id: ObjectId = ObjectId(),

    @Indexed
    val kind: ItemKind,

    @Indexed
    var type: LinkedHashSet<ItemTag>,

    @Indexed
    val name: String,

    @Indexed
    val options: LinkedHashSet<String>,

    val subOptions: LinkedHashSet<String>,

    val condition: LinkedHashSet<String>,
)
