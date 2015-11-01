package com.movile.quickbuck.queueapp.database.dao;

import android.content.Context;
import android.database.Cursor;

import com.movile.quickbuck.queueapp.Usuario;
import com.movile.quickbuck.queueapp.database.manual.entity.UserEntity;
import com.raizlabs.android.dbflow.sql.builder.Condition;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.Select;

public class UserDAO {

    private Context mContext;

    public UserDAO(Context context) {
        mContext = context;
    }

    public void save(Usuario user) {
        UserEntity entity = new UserEntity(user.nome(), user.senha(), user.restaurante());
        entity.save();
    }

    public Cursor all() {
        Cursor cursor = new Select().from(UserEntity.class).queryCursorList().getCursor();
        return cursor;
    }

    public Usuario query(String nome) {
        UserEntity entity = new Select()
                .from(UserEntity.class)
                .where(Condition.column(UserEntity.FavoriteEntityFields.COLUMN_SLUG).eq(nome))
                .querySingle();

        if (entity != null) {
            Usuario user = new Usuario(entity.nome(), entity.senha(), entity.restaurante());
            return user;
        } else {
            return null;
        }
    }

    public void delete(String nome) {
        new Delete()
                .from(UserEntity.class)
                .where(Condition.column(UserEntity.FavoriteEntityFields.COLUMN_SLUG).eq(nome))
                .queryClose();
    }

}