package com.virtualstudios.realestatemanager.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.virtualstudios.realestatemanager.async.AsyncDBDelete;
import com.virtualstudios.realestatemanager.async.AsyncDBInsert;
import com.virtualstudios.realestatemanager.async.AsyncDBUpdate;
import com.virtualstudios.realestatemanager.db.RealEstateDao;
import com.virtualstudios.realestatemanager.db.RoomDB;
import com.virtualstudios.realestatemanager.model.FilterParams;
import com.virtualstudios.realestatemanager.model.RealEstate;

import java.util.List;

import static com.virtualstudios.realestatemanager.utils.Constants.Status.AVAILABLE;
import static com.virtualstudios.realestatemanager.utils.Constants.Status.SOLD;

public class Repository {
    private RealEstateDao dao;

    public Repository(Context context) {
        dao = RoomDB.getInstance(context).getDao();
    }

    public void insertListing(RealEstate realEstate) {
        new AsyncDBInsert(dao).execute(realEstate);
    }

    public void updateListing(RealEstate realEstate) {
        new AsyncDBUpdate(dao).execute(realEstate);
    }

    public void deleteListing(RealEstate realEstate) {
        new AsyncDBDelete(dao).execute(realEstate);
    }

    public LiveData<List<RealEstate>> getAllListings() {
        return dao.getAllListings();
    }

    public LiveData<List<RealEstate>> filterList(FilterParams filterParamse) {
        String soldTerm = "";
        String availableTerm = "";
        if (filterParamse.isSold()) {
            soldTerm = SOLD;
        }
        if (filterParamse.isAvailable()) {
            availableTerm = AVAILABLE;
        }
        return dao.getFilteredListing(
                filterParamse.getMinSurfaceArea(),
                filterParamse.getMaxSurfaceArea()
                , filterParamse.getMinNumOfRooms()
                , filterParamse.getMaxNumOfRooms()
                , filterParamse.getMinNumOfBedRooms()
                , filterParamse.getMaxNumOfBedRooms()
                , soldTerm
                , availableTerm
        );
    }

    public LiveData<List<RealEstate>> geSearchedListings(String term) {
        return dao.getSearchedListing(term);
    }
}
