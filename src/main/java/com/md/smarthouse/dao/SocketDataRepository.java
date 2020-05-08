package com.md.smarthouse.dao;

import com.md.smarthouse.model.SocketData;

public interface SocketDataRepository {
    void setData(SocketData socketData);
    SocketData getCurrent();
}
