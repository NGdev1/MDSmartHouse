package com.md.smarthouse.dao.impl;

import com.md.smarthouse.dao.SocketDataRepository;
import com.md.smarthouse.model.SocketData;
import org.springframework.stereotype.Service;

@Service
public class SocketDataRepositoryImpl implements SocketDataRepository {

    private SocketData socketData;

    SocketDataRepositoryImpl() {
        socketData = new SocketData();
    }

    @Override
    public void setData(SocketData socketData) {
        this.socketData = socketData;
    }

    @Override
    public SocketData getCurrent() {
        return socketData;
    }
}
