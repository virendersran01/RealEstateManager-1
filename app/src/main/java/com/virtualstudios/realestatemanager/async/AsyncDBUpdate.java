package com.virtualstudios.realestatemanager.async;

import android.os.AsyncTask;

import com.virtualstudios.realestatemanager.db.RealEstateDao;
import com.virtualstudios.realestatemanager.model.RealEstate;

public class AsyncDBUpdate extends AsyncTask<RealEstate, Void, Void> {

    private RealEstateDao dao;

    public AsyncDBUpdate(RealEstateDao dao) {
        this.dao = dao;
    }

    @Override
    protected Void doInBackground(RealEstate... realEstates) {
        dao.updateRealEstate(realEstates);
        return null;
    }
}
