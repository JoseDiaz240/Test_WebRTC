package com.dds.nodejs;

import android.app.Activity;
import android.text.TextUtils;

import com.dds.webrtclib.WebRTCManager;
import com.dds.webrtclib.bean.MediaType;
import com.dds.webrtclib.bean.MyIceServer;
import com.dds.webrtclib.ui.ChatRoomActivity;
import com.dds.webrtclib.ui.ChatSingleActivity;
import com.dds.webrtclib.ws.IConnectEvent;

public class WebrtcUtil {


    public static final String HOST = "ad4fb13020b5.ngrok.io";
    public static final String HOST1 = "0686f048598a.ngrok.io";
    public static final String HOST2 = "52.149.214.3:3470";

    // turn and stun
    private static MyIceServer[] iceServers = {
            //new MyIceServer("stun:stun.l.google.com:19302"),

            // Dirección de prueba 1
            new MyIceServer("stun:" + HOST2 + "?transport=udp"),
            new MyIceServer("turn:" + HOST2 + "?transport=udp",
                    "aza",
                    "123"),
            new MyIceServer("turn:" + HOST2 + "?transport=tcp",
                    "aza",
                    "123"),
    };

    // signalling
    private static String WSS = "wss://" + HOST1 + "/wss";
    // Dirección de señalización de prueba local
    // private static String WSS = "ws://192.168.1.138:3000";

    // one to one
    public static void callSingle(Activity activity, String wss, String roomId, boolean videoEnable) {
        if (TextUtils.isEmpty(wss)) {
            wss = WSS;
        }
        WebRTCManager.getInstance().init(wss, iceServers, new IConnectEvent() {
            @Override
            public void onSuccess() {
                ChatSingleActivity.openActivity(activity, videoEnable);
            }

            @Override
            public void onFailed(String msg) {

            }
        });
        WebRTCManager.getInstance().connect(videoEnable ? MediaType.TYPE_VIDEO : MediaType.TYPE_AUDIO, roomId);
    }

    // Videoconferencing
    public static void call(Activity activity, String wss, String roomId) {
        if (TextUtils.isEmpty(wss)) {
            wss = WSS;
        }
        WebRTCManager.getInstance().init(wss, iceServers, new IConnectEvent() {
            @Override
            public void onSuccess() {
                ChatRoomActivity.openActivity(activity);
            }

            @Override
            public void onFailed(String msg) {

            }
        });
        WebRTCManager.getInstance().connect(MediaType.TYPE_MEETING, roomId);
    }


}
