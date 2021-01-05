package com.virtualstudios.realestatemanager.async;

import android.os.AsyncTask;

import com.virtualstudios.realestatemanager.db.RealEstateDao;
import com.virtualstudios.realestatemanager.model.RealEstate;

public class AsyncDBInsert extends AsyncTask<RealEstate, Void, Void> {

    private RealEstateDao dao;

    public AsyncDBInsert(RealEstateDao dao) {
        this.dao = dao;
    }

    @Override
    protected Void doInBackground(RealEstate... realEstates) {
        dao.insertRealEstate(realEstates);
        return null;
    }
}
