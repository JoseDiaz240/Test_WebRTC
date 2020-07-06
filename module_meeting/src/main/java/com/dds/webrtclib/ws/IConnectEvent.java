package com.dds.webrtclib.ws;

public interface IConnectEvent {

    void onSuccess();

    void onFailed(String msg);
}
