package co.com.app.homerepair.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.List;

import co.com.app.homerepair.model.Rol;
import co.com.app.homerepair.model.Usuarios;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "USUARIOS".
*/
public class UsuariosDao extends AbstractDao<Usuarios, Long> {

    public static final String TABLENAME = "USUARIOS";

    /**
     * Properties of entity Usuarios.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Usu_nombre = new Property(1, String.class, "usu_nombre", false, "USU_NOMBRE");
        public final static Property Usu_pass = new Property(2, String.class, "usu_pass", false, "USU_PASS");
        public final static Property Usu_img_perfil = new Property(3, byte[].class, "usu_img_perfil", false, "USU_IMG_PERFIL");
        public final static Property Usu_estado = new Property(4, String.class, "usu_estado", false, "USU_ESTADO");
        public final static Property Usu_rol_id = new Property(5, Long.class, "usu_rol_id", false, "USU_ROL_ID");
    }

    private DaoSession daoSession;

    private Query<Usuarios> rol_UsuariosQuery;

    public UsuariosDao(DaoConfig config) {
        super(config);
    }
    
    public UsuariosDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USUARIOS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"USU_NOMBRE\" TEXT UNIQUE ," + // 1: usu_nombre
                "\"USU_PASS\" TEXT," + // 2: usu_pass
                "\"USU_IMG_PERFIL\" BLOB," + // 3: usu_img_perfil
                "\"USU_ESTADO\" TEXT," + // 4: usu_estado
                "\"USU_ROL_ID\" INTEGER);"); // 5: usu_rol_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USUARIOS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Usuarios entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String usu_nombre = entity.getUsu_nombre();
        if (usu_nombre != null) {
            stmt.bindString(2, usu_nombre);
        }
 
        String usu_pass = entity.getUsu_pass();
        if (usu_pass != null) {
            stmt.bindString(3, usu_pass);
        }
 
        byte[] usu_img_perfil = entity.getUsu_img_perfil();
        if (usu_img_perfil != null) {
            stmt.bindBlob(4, usu_img_perfil);
        }
 
        String usu_estado = entity.getUsu_estado();
        if (usu_estado != null) {
            stmt.bindString(5, usu_estado);
        }
 
        Long usu_rol_id = entity.getUsu_rol_id();
        if (usu_rol_id != null) {
            stmt.bindLong(6, usu_rol_id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Usuarios entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String usu_nombre = entity.getUsu_nombre();
        if (usu_nombre != null) {
            stmt.bindString(2, usu_nombre);
        }
 
        String usu_pass = entity.getUsu_pass();
        if (usu_pass != null) {
            stmt.bindString(3, usu_pass);
        }
 
        byte[] usu_img_perfil = entity.getUsu_img_perfil();
        if (usu_img_perfil != null) {
            stmt.bindBlob(4, usu_img_perfil);
        }
 
        String usu_estado = entity.getUsu_estado();
        if (usu_estado != null) {
            stmt.bindString(5, usu_estado);
        }
 
        Long usu_rol_id = entity.getUsu_rol_id();
        if (usu_rol_id != null) {
            stmt.bindLong(6, usu_rol_id);
        }
    }

    @Override
    protected final void attachEntity(Usuarios entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Usuarios readEntity(Cursor cursor, int offset) {
        Usuarios entity = new Usuarios( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // usu_nombre
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // usu_pass
            cursor.isNull(offset + 3) ? null : cursor.getBlob(offset + 3), // usu_img_perfil
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // usu_estado
            cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5) // usu_rol_id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Usuarios entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUsu_nombre(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUsu_pass(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUsu_img_perfil(cursor.isNull(offset + 3) ? null : cursor.getBlob(offset + 3));
        entity.setUsu_estado(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUsu_rol_id(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Usuarios entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Usuarios entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Usuarios entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "usuarios" to-many relationship of Rol. */
    public List<Usuarios> _queryRol_Usuarios(Long usu_rol_id) {
        synchronized (this) {
            if (rol_UsuariosQuery == null) {
                QueryBuilder<Usuarios> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Usu_rol_id.eq(null));
                rol_UsuariosQuery = queryBuilder.build();
            }
        }
        Query<Usuarios> query = rol_UsuariosQuery.forCurrentThread();
        query.setParameter(0, usu_rol_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getRolDao().getAllColumns());
            builder.append(" FROM USUARIOS T");
            builder.append(" LEFT JOIN ROL T0 ON T.\"USU_ROL_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Usuarios loadCurrentDeep(Cursor cursor, boolean lock) {
        Usuarios entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Rol rol = loadCurrentOther(daoSession.getRolDao(), cursor, offset);
        entity.setRol(rol);

        return entity;    
    }

    public Usuarios loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Usuarios> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Usuarios> list = new ArrayList<Usuarios>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<Usuarios> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Usuarios> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
