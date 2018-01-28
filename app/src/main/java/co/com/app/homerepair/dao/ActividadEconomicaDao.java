package co.com.app.homerepair.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import co.com.app.homerepair.model.ActividadEconomica;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ACTIVIDAD_ECONOMICA".
*/
public class ActividadEconomicaDao extends AbstractDao<ActividadEconomica, Long> {

    public static final String TABLENAME = "ACTIVIDAD_ECONOMICA";

    /**
     * Properties of entity ActividadEconomica.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Ae_descripcion = new Property(1, String.class, "ae_descripcion", false, "AE_DESCRIPCION");
        public final static Property Ae_estado = new Property(2, String.class, "ae_estado", false, "AE_ESTADO");
    }

    private DaoSession daoSession;


    public ActividadEconomicaDao(DaoConfig config) {
        super(config);
    }
    
    public ActividadEconomicaDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ACTIVIDAD_ECONOMICA\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"AE_DESCRIPCION\" TEXT," + // 1: ae_descripcion
                "\"AE_ESTADO\" TEXT);"); // 2: ae_estado
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ACTIVIDAD_ECONOMICA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ActividadEconomica entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String ae_descripcion = entity.getAe_descripcion();
        if (ae_descripcion != null) {
            stmt.bindString(2, ae_descripcion);
        }
 
        String ae_estado = entity.getAe_estado();
        if (ae_estado != null) {
            stmt.bindString(3, ae_estado);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ActividadEconomica entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String ae_descripcion = entity.getAe_descripcion();
        if (ae_descripcion != null) {
            stmt.bindString(2, ae_descripcion);
        }
 
        String ae_estado = entity.getAe_estado();
        if (ae_estado != null) {
            stmt.bindString(3, ae_estado);
        }
    }

    @Override
    protected final void attachEntity(ActividadEconomica entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ActividadEconomica readEntity(Cursor cursor, int offset) {
        ActividadEconomica entity = new ActividadEconomica( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // ae_descripcion
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // ae_estado
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ActividadEconomica entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAe_descripcion(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAe_estado(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ActividadEconomica entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ActividadEconomica entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ActividadEconomica entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
