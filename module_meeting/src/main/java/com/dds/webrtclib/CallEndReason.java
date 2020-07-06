package com.dds.webrtclib;

public enum CallEndReason {
    Busy,
    SignalError,
    Hangup,
    MediaError,
    RemoteHangup,
    OpenCameraFailure,
    Timeout,
    AcceptByOtherClient;

    private CallEndReason() {
    }
}
