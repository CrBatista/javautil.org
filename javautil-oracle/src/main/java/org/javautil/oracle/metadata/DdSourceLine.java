package org.javautil.oracle.metadata;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.javautil.jdbc.ResultSetPopulable;
import org.javautil.oracle.dao.ObjectSourceDAO;
/**
  * Contains a temporal representation of the data persisted in a tuple of DBA_SOURCE
.
  * This code was generated by com.javautil.JavaGen.BaseRowGenerator on Thu Oct 16 10:35:00 EDT 2008
  */
public class DdSourceLine implements ResultSetPopulable {
   /** Container for the data persisted in OWNER. varchar2(30) */
     private String owner = null;

   /** Container for the data persisted in NAME. varchar2(30) */
     private String name = null;

   /** Container for the data persisted in TYPE. varchar2(12) */
     private String type = null;

   /** Container for the data persisted in LINE. number(22) */
     private int line;

   /** Container for the data persisted in TEXT. varchar2(4000) */
     private String text = null;

    /** Accessor set method for owner.
     No validation provided in base method. */
    public void setOwner(String val) {
        owner = val;
    }

    /** Accessor get method for owner. */
    public String getOwner() {
        return owner;
    }


    /** Accessor set method for name.
     No validation provided in base method. */
    public void setName(String val) {
        name = val;
    }

    /** Accessor get method for name. */
    public String getName() {
        return name;
    }


    /** Accessor set method for type.
     No validation provided in base method. */
    public void setType(String val) {
        type = val;
    }

    /** Accessor get method for type. */
    public String getType() {
        return type;
    }


    /** Accessor set method for line.
     No validation provided in base method. */
    public void setLine(int val) {
        line = val;
    }

    /** Accessor get method for line. */
    public int getLine() {
        return line;
    }


    /** Accessor set method for text.
     No validation provided in base method. */
    public void setText(String val) {
        text = val;
    }

    /** Accessor get method for text. */
    public String getText() {
        return text;
    }


	public void setValues(ResultSet rset) throws SQLException {
		ObjectSourceDAO.getRow(rset,this);
	}
}
