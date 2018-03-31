package com.suitepad.sessionone.db;

import android.provider.BaseColumns;

/**
 * Created by Eslam Hussein on 3/30/18.
 */

public final class PersonContract {

    private PersonContract() {

    }

    static class PersonEntity implements BaseColumns {

        static final String TABLE_NAME = "people";
        static final String NAME = "name";
        static final String AGE = "age";
        static final String HEIGHT = "height";

    }

}
