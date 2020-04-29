package com.coelhoptbr.vw.service;

import com.coelhoptbr.vw.dto.InCoordinateDTO;
import com.coelhoptbr.vw.dto.OutCoordinateDTO;

import java.util.concurrent.ExecutionException;

public interface ICoordinateService {

    public String create(InCoordinateDTO coords) throws ExecutionException, InterruptedException;

    public OutCoordinateDTO get(String plate) throws ExecutionException, InterruptedException;

    public void delete(String plate) throws ExecutionException, InterruptedException;
}
