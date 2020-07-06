package com.dds.webrtclib;

public enum CallState {
    Idle,
    Outgoing,
    Incoming,
    Connecting,
    Connected;

    private CallState() {
    }
}