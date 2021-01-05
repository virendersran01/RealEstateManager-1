package com.virtualstudios.realestatemanager.async;

import android.os.AsyncTask;

import com.virtualstudios.realestatemanager.db.RealEstateDao;
import com.virtualstudios.realestatemanager.model.RealEstate;

public class AsyncDBDelete extends AsyncTask<RealEstate, Void, Void> {

    private RealEstateDao dao;

    public AsyncDBDelete(RealEstateDao dao) {
        this.dao = dao;
    }

    @Override
    protected Void doInBackground(RealEstate... realEstates) {
        dao.deleteRealEstate(realEstates);
        return null;
    }
}
