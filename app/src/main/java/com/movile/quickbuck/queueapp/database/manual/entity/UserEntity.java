package com.movile.quickbuck.queueapp.database.manual.entity;

import android.provider.BaseColumns;

import com.movile.quickbuck.queueapp.database.QueueDatabase;
import com.movile.quickbuck.queueapp.database.manual.helper.DatabaseHelper;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(databaseName = QueueDatabase.NAME)
public class UserEntity extends BaseModel {
    @Column(name = BaseColumns._ID)
    @PrimaryKey(autoincrement = true)
    Long id;

    @Column
    String nome;

    @Column
    String senha;

    @Column
    String restaurante;

    public static class FavoriteEntityFields implements BaseColumns {
        public static final String TABLE_NAME = "usuario";

        public static final String COLUMN_SLUG = "nome";
        public static final String COLUMN_TITLE = "senha";
        public static final String COLUMN_RESTAURANTE = "restaurante";

        public static final String COLUMN_SLUG_TYPE = "text";
        public static final String COLUMN_NAME_TYPE = "text";
        public static final String COLUMN_RESTAURANTE_TYPE = "text";

        public static String createSql() {
            StringBuilder builder = new StringBuilder();
            builder.append("create table ").append(TABLE_NAME).append(" (");
            builder.append(DatabaseHelper.createColumnSql(_ID, "integer", "primary key", true));
            builder.append(DatabaseHelper.createColumnSql(COLUMN_SLUG, COLUMN_SLUG_TYPE, "", true));
            builder.append(DatabaseHelper.createColumnSql(COLUMN_TITLE, COLUMN_NAME_TYPE, "", false));
            builder.append(DatabaseHelper.createColumnSql(COLUMN_RESTAURANTE, COLUMN_RESTAURANTE_TYPE, "", true));
            builder.append(");");

            return builder.toString();
        }

        public static String dropSql() {
            return DatabaseHelper.dropSql(TABLE_NAME);
        }
    }

    public UserEntity() {
    }

    public UserEntity(String mnome, String msenha, String mrestaurante) { // FIXME
        nome = mnome;
        senha = msenha;
        restaurante = mrestaurante;
    }

    public String nome() {
        return nome;
    }

    public String senha() {
        return senha;
    }

    public String restaurante() {
        return restaurante;
    }
}