package com.example.ecom.inventory.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QInventory is a Querydsl query type for Inventory
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QInventory extends EntityPathBase<Inventory> {

    private static final long serialVersionUID = -754128444;

    public static final QInventory inventory = new QInventory("inventory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath productId = createString("productId");

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public QInventory(String variable) {
        super(Inventory.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QInventory(Path<? extends Inventory> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QInventory(PathMetadata<?> metadata) {
        super(Inventory.class, metadata);
    }

}

