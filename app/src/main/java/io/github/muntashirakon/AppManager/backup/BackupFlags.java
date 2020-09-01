/*
 * Copyright (C) 2020 Muntashir Al-Islam
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.muntashirakon.AppManager.backup;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

class BackupFlags {
    @IntDef(flag = true, value = {
            BACKUP_NOTHING,
            BACKUP_SOURCE,
            BACKUP_SOURCE_APK_ONLY,
            BACKUP_DATA,
            BACKUP_EXT_DATA,
            BACKUP_EXT_OBB_MEDIA,
            BACKUP_EXCLUDE_CACHE,
            BACKUP_RULES,
            BACKUP_NO_SIGNATURE_CHECK,
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface BackupFlag {
    }

    public static final int BACKUP_NOTHING = 0;
    @SuppressWarnings("PointlessBitwiseExpression")
    public static final int BACKUP_SOURCE = 1 << 0;
    public static final int BACKUP_DATA = 1 << 1;
    public static final int BACKUP_EXT_DATA = 1 << 2;
    public static final int BACKUP_EXCLUDE_CACHE = 1 << 3;
    public static final int BACKUP_RULES = 1 << 4;
    public static final int BACKUP_NO_SIGNATURE_CHECK = 1 << 5;
    public static final int BACKUP_SOURCE_APK_ONLY = 1 << 6;
    public static final int BACKUP_EXT_OBB_MEDIA = 1 << 7;  // TODO
    public static final int BACKUP_ALL_USERS = 1 << 8;  // TODO
    public static final int BACKUP_MULTIPLE = 1 << 8;  // TODO
    public static final int BACKUP_FLAGS_COMPAT = (1 << 8) - 1;

    @BackupFlag
    private int flags;

    BackupFlags(@BackupFlag int flags) {
        this.flags = flags;
    }

    public int getFlags() {
        return flags;
    }

    boolean isEmpty() {
        return flags == 0;
    }

    boolean backupSource() {
        return (flags & BACKUP_SOURCE) != 0;
    }

    boolean backupOnlyApk() {
        return (flags & BACKUP_SOURCE_APK_ONLY) != 0;
    }

    boolean backupData() {
        return (flags & BACKUP_DATA) != 0;
    }

    boolean backupExtData() {
        return (flags & BACKUP_EXT_DATA) != 0;
    }

    boolean backupMediaObb() {
        return (flags & BACKUP_EXT_OBB_MEDIA) != 0;
    }

    boolean backupRules() {
        return (flags & BACKUP_RULES) != 0;
    }

    boolean excludeCache() {
        return (flags & BACKUP_EXCLUDE_CACHE) != 0;
    }

    boolean noSignatureCheck() {
        return (flags & BACKUP_NO_SIGNATURE_CHECK) != 0;
    }

    boolean backupMultiple() {
        return (flags & BACKUP_MULTIPLE) != 0;
    }

    boolean backupAllUsers() {
        return (flags & BACKUP_ALL_USERS) != 0;
    }
}