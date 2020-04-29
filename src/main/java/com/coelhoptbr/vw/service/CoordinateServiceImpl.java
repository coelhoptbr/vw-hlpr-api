package com.coelhoptbr.vw.service;

import com.coelhoptbr.vw.dto.InCoordinateDTO;
import com.coelhoptbr.vw.dto.OutCoordinateDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CoordinateServiceImpl extends BaseService implements ICoordinateService {

    private final String COLLECTION = "coordinates";

    @Override
    public String create(InCoordinateDTO coords) throws ExecutionException, InterruptedException {
        OutCoordinateDTO newCoords = new OutCoordinateDTO(coords.getPlate(), coords.getLocation());

        ApiFuture<WriteResult> future = getCollection(COLLECTION)
                .document(newCoords.getPlate()).set(newCoords);
        return future.get().getUpdateTime().toString();
    }

    @Override
    public OutCoordinateDTO get(String plate) throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = getCollection(COLLECTION)
                .whereEqualTo("plate", plate).get();

        if (!future.get().getDocuments().isEmpty()) {
            return future.get().getDocuments().get(0).toObject(OutCoordinateDTO.class);
        }

        return null;
    }

    @Override
    public void delete(String plate) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> writeResult = getCollection(COLLECTION).document(plate).delete();
        writeResult.get().getUpdateTime().toString();
    }
}