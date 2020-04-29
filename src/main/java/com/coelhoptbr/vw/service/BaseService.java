package com.coelhoptbr.vw.service;

import com.google.cloud.firestore.CollectionReference;
import com.google.firebase.cloud.FirestoreClient;

public class BaseService {

    protected CollectionReference getCollection(String name) {
        return FirestoreClient.getFirestore().collection(name);
    }

}
