/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.deepakvadgama.radhekrishnabhakti.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Defines table and column names for the database.
 */
public class DatabaseContract {

    public static final String PATH_CONTENT = "content";
    public static final String PATH_FAVORITE = "favorite";

    public static final String CONTENT_AUTHORITY = "com.deepakvadgama.radhekrishnabhakti";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final class FavoritesEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_FAVORITE).build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FAVORITE;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_FAVORITE;

        public static final String TABLE_NAME = "favorites";
        public static final String COLUMN_CONTENT_ID = "content_id";

        public static Uri buildFavoriteUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }

    public static final class ContentEntry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_CONTENT).build();
        public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CONTENT;
        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_CONTENT;

        public static final String TABLE_NAME = "content";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_TEXT = "text";
        public static final String ANY = "any";

        public static Uri buildContentSearchWithType(String type) {
            return CONTENT_URI.buildUpon().appendQueryParameter(COLUMN_TYPE, type).build();
        }

        public static Uri buildContentSearchWithAuthor(String author) {
            return CONTENT_URI.buildUpon().appendQueryParameter(COLUMN_AUTHOR, author).build();
        }

        public static Uri buildContentSearchWithTitle(String title) {
            return CONTENT_URI.buildUpon().appendQueryParameter(COLUMN_TITLE, title).build();
        }

        public static Uri buildContentSearchWithAny(String title) {
            return CONTENT_URI.buildUpon().appendQueryParameter(ANY, title).build();
        }

        public static String getTitleFromUri(Uri uri) {
            return uri.getQueryParameter(COLUMN_TITLE);
        }

        public static String getTypeFromUri(Uri uri) {
            return uri.getQueryParameter(COLUMN_TYPE);
        }

        public static String getAuthorFromUri(Uri uri) {
            return uri.getQueryParameter(COLUMN_AUTHOR);
        }

        public static String getSearchFromUri(Uri uri) {
            return uri.getQueryParameter(ANY);
        }

        public static Uri buildContentUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}
