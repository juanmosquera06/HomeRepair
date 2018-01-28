package co.com.app.homerepair.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import co.com.app.homerepair.model.Adjunto;
import co.com.app.homerepair.model.Solicitud;

import co.com.app.homerepair.model.AdjuntoSolicitud;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ADJUNTO_SOLICITUD".
*/
public class AdjuntoSolicitudDao extends AbstractDao<AdjuntoSolicitud, Long> {

    public static final String TABLENAME = "ADJUNTO_SOLICITUD";

    /**
     * Properties of entity AdjuntoSolicitud.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Sol_id = new Property(1, Long.class, "sol_id", false, "SOL_ID");
        public final static Property Adj_id = new Property(2, Long.class, "adj_id", false, "ADJ_ID");
    }

    private DaoSession daoSession;

    private Query<AdjuntoSolicitud> solicitud_AdjuntosSolicitudQuery;
    private Query<AdjuntoSolicitud> adjunto_AdjuntosSolicitudQuery;

    public AdjuntoSolicitudDao(DaoConfig config) {
        super(config);
    }
    
    public AdjuntoSolicitudDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ADJUNTO_SOLICITUD\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"SOL_ID\" INTEGER UNIQUE ," + // 1: sol_id
                "\"ADJ_ID\" INTEGER UNIQUE );"); // 2: adj_id
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_ADJUNTO_SOLICITUD_SOL_ID ON ADJUNTO_SOLICITUD" +
                " (\"SOL_ID\");");
        db.execSQL("CREATE INDEX " + constraint + "IDX_ADJUNTO_SOLICITUD_ADJ_ID ON ADJUNTO_SOLICITUD" +
                " (\"ADJ_ID\");");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ADJUNTO_SOLICITUD\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, AdjuntoSolicitud entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long sol_id = entity.getSol_id();
        if (sol_id != null) {
            stmt.bindLong(2, sol_id);
        }
 
        Long adj_id = entity.getAdj_id();
        if (adj_id != null) {
            stmt.bindLong(3, adj_id);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, AdjuntoSolicitud entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long sol_id = entity.getSol_id();
        if (sol_id != null) {
            stmt.bindLong(2, sol_id);
        }
 
        Long adj_id = entity.getAdj_id();
        if (adj_id != null) {
            stmt.bindLong(3, adj_id);
        }
    }

    @Override
    protected final void attachEntity(AdjuntoSolicitud entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public AdjuntoSolicitud readEntity(Cursor cursor, int offset) {
        AdjuntoSolicitud entity = new AdjuntoSolicitud( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // sol_id
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // adj_id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, AdjuntoSolicitud entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSol_id(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setAdj_id(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(AdjuntoSolicitud entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(AdjuntoSolicitud entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(AdjuntoSolicitud entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "adjuntosSolicitud" to-many relationship of Solicitud. */
    public List<AdjuntoSolicitud> _querySolicitud_AdjuntosSolicitud(Long sol_id) {
        synchronized (this) {
            if (solicitud_AdjuntosSolicitudQuery == null) {
                QueryBuilder<AdjuntoSolicitud> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Sol_id.eq(null));
                solicitud_AdjuntosSolicitudQuery = queryBuilder.build();
            }
        }
        Query<AdjuntoSolicitud> query = solicitud_AdjuntosSolicitudQuery.forCurrentThread();
        query.setParameter(0, sol_id);
        return query.list();
    }

    /** Internal query to resolve the "adjuntosSolicitud" to-many relationship of Adjunto. */
    public List<AdjuntoSolicitud> _queryAdjunto_AdjuntosSolicitud(Long adj_id) {
        synchronized (this) {
            if (adjunto_AdjuntosSolicitudQuery == null) {
                QueryBuilder<AdjuntoSolicitud> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Adj_id.eq(null));
                adjunto_AdjuntosSolicitudQuery = queryBuilder.build();
            }
        }
        Query<AdjuntoSolicitud> query = adjunto_AdjuntosSolicitudQuery.forCurrentThread();
        query.setParameter(0, adj_id);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getSolicitudDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getAdjuntoDao().getAllColumns());
            builder.append(" FROM ADJUNTO_SOLICITUD T");
            builder.append(" LEFT JOIN SOLICITUD T0 ON T.\"SOL_ID\"=T0.\"_id\"");
            builder.append(" LEFT JOIN ADJUNTO T1 ON T.\"ADJ_ID\"=T1.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected AdjuntoSolicitud loadCurrentDeep(Cursor cursor, boolean lock) {
        AdjuntoSolicitud entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Solicitud solicitud = loadCurrentOther(daoSession.getSolicitudDao(), cursor, offset);
        entity.setSolicitud(solicitud);
        offset += daoSession.getSolicitudDao().getAllColumns().length;

        Adjunto adjunto = loadCurrentOther(daoSession.getAdjuntoDao(), cursor, offset);
        entity.setAdjunto(adjunto);

        return entity;    
    }

    public AdjuntoSolicitud loadDeep(Long key) {
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
    public List<AdjuntoSolicitud> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<AdjuntoSolicitud> list = new ArrayList<AdjuntoSolicitud>(count);
        
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
    
    protected List<AdjuntoSolicitud> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<AdjuntoSolicitud> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
