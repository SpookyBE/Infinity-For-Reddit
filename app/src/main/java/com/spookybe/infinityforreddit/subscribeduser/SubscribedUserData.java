package com.spookybe.infinityforreddit.subscribeduser;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import com.spookybe.infinityforreddit.account.Account;

@Entity(tableName = "subscribed_users", primaryKeys = {"name", "username"},
        foreignKeys = @ForeignKey(entity = Account.class, parentColumns = "username",
        childColumns = "username", onDelete = ForeignKey.CASCADE))
public class SubscribedUserData {
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "icon")
    private String iconUrl;
    @NonNull
    @ColumnInfo(name = "username")
    private String username;
    @ColumnInfo(name = "is_favorite")
    private boolean favorite;

    public SubscribedUserData(@NonNull String name, String iconUrl, @NonNull String username, boolean favorite) {
        this.name = name;
        this.iconUrl = iconUrl;
        this.username = username;
        this.favorite = favorite;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }
}
