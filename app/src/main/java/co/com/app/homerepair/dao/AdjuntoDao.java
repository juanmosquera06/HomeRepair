package co.com.app.homerepair.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import co.com.app.homerepair.model.Adjunto;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ADJUNTO".
*/
public class AdjuntoDao extends AbstractDao<Adjunto, Long> {

    public static final String TABLENAME = "ADJUNTO";

    /**
     * Properties of entity Adjunto.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Adj_img = new Property(1, byte[].class, "adj_img", false, "ADJ_IMG");
    }

    private DaoSession daoSession;


    public AdjuntoDao(DaoConfig config) {
        super(config);
    }
    
    public AdjuntoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ADJUNTO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"ADJ_IMG\" BLOB);"); // 1: adj_img
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ADJUNTO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Adjunto entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        byte[] adj_img = entity.getAdj_img();
        if (adj_img != null) {
            stmt.bindBlob(2, adj_img);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Adjunto entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        byte[] adj_img = entity.getAdj_img();
        if (adj_img != null) {
            stmt.bindBlob(2, adj_img);
        }
    }

    @Override
    protected final void attachEntity(Adjunto entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Adjunto readEntity(Cursor cursor, int offset) {
        Adjunto entity = new Adjunto( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getBlob(offset + 1) // adj_img
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Adjunto entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAdj_img(cursor.isNull(offset + 1) ? null : cursor.getBlob(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Adjunto entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Adjunto entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Adjunto entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
