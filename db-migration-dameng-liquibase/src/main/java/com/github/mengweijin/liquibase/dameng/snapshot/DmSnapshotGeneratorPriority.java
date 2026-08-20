package com.github.mengweijin.liquibase.dameng.snapshot;

import liquibase.snapshot.SnapshotGenerator;
import liquibase.structure.DatabaseObject;

final class DmSnapshotGeneratorPriority {

    private DmSnapshotGeneratorPriority() {
    }

    static int fromCore(SnapshotGenerator generator, Class<? extends DatabaseObject> objectType, int corePriority) {
        Class<? extends DatabaseObject>[] containers = generator.addsTo();
        if (containers != null) {
            for (Class<? extends DatabaseObject> container : containers) {
                if (container.isAssignableFrom(objectType)) {
                    return SnapshotGenerator.PRIORITY_ADDITIONAL + 1;
                }
            }
        }
        return corePriority == SnapshotGenerator.PRIORITY_NONE
                ? SnapshotGenerator.PRIORITY_NONE : corePriority + 1;
    }
}
